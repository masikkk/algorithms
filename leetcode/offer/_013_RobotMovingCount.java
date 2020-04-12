package leetcode.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

/**
 * 《剑指offer》面试题13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @author masikkk.com
 * @create 2020-04-08 11:57
 */
public class _013_RobotMovingCount {
    // 深度优先搜索 最快
    private static class SolutionV2020_DFS {
        private int count;
        private int rows, columns;
        // 访问过的坐标
        private Set<Pair<Integer, Integer>> visited;

        public int movingCount(int m, int n, int k) {
            count = 0;
            rows = m;
            columns = n;
            visited = new HashSet<>();
            dfs(0, 0, k);
            return count;
        }

        private void dfs(int x, int y, int k) {
            if (x >= rows || y >= columns || (x/10 + x%10) + (y/10 + y%10) > k) {
                return;
            }
            Pair<Integer, Integer> pair = new Pair<>(x, y);
            if (visited.contains(pair)) {
                return;
            }
            count++;
            visited.add(pair);
            // 下
            dfs(x + 1, y, k);
            // 右下
            dfs(x + 1, y + 1, k);
            // 右 ️
            dfs(x, y + 1, k);
        }
    }

    @Test
    public void testDfs() {
        SolutionV2020_DFS solutionV2020_dfs = new SolutionV2020_DFS();
        System.out.println(solutionV2020_dfs.movingCount(2, 3, 1));
        System.out.println(solutionV2020_dfs.movingCount(3, 1, 0));
        System.out.println(solutionV2020_dfs.movingCount(3, 2, 17));
        System.out.println(solutionV2020_dfs.movingCount(11, 8, 16));
        System.out.println(solutionV2020_dfs.movingCount(36, 11, 15));
    }

    // BFS，合法的下层结点才入队列
    private static class SolutionV2020_BFS_ValidEnQueue {
        public int movingCount(int m, int n, int k) {
            int count = 0;
            Set<Pair<Integer, Integer>> visited = new HashSet<>();
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(0, 0));
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> pair = queue.poll();
                if (!visited.contains(pair)) {
                    visited.add(pair);
                    count++;
                    int x = pair.getKey(), y = pair.getValue();
                    if (valid(x+1, y, m, n, k)) {
                        queue.offer(new Pair<>(x+1, y));
                    }
                    if (valid(x+1, y+1, m, n, k)) {
                        queue.offer(new Pair<>(x+1, y+1));
                    }
                    if (valid(x, y+1, m, n, k)) {
                        queue.offer(new Pair<>(x, y+1));
                    }
                }
            }
            return count;
        }

        // 判断(x,y)是否合法
        private boolean valid(int x, int y, int m, int n, int k) {
            if (x < m && y < n && (x / 10 + x % 10 + y / 10 + y % 10) <= k) {
                return true;
            }
            return false;
        }
    }

    @Test
    public void testBfsValidEnQueue() {
        SolutionV2020_BFS_ValidEnQueue solutionV2020_bfs_validEnQueue = new SolutionV2020_BFS_ValidEnQueue();
        System.out.println(solutionV2020_bfs_validEnQueue.movingCount(2, 3, 1));
        System.out.println(solutionV2020_bfs_validEnQueue.movingCount(3, 1, 0));
        System.out.println(solutionV2020_bfs_validEnQueue.movingCount(3, 2, 17));
        System.out.println(solutionV2020_bfs_validEnQueue.movingCount(11, 8, 16));
        System.out.println(solutionV2020_bfs_validEnQueue.movingCount(36, 11, 15));
    }

    // BFS，下一层不判断就入队
    private static class SolutionV2020_BFS_AllEnQueue {
        public int movingCount(int m, int n, int k) {
            int count = 0;
            Set<Pair<Integer, Integer>> visited = new HashSet<>();
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(0, 0));
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> pair = queue.poll();
                if (!visited.contains(pair)) {
                    visited.add(pair);
                    int x = pair.getKey(), y = pair.getValue();
                    if (x < m && y < n && (x/10 + x%10 + y/10 + y%10) <= k) {
                        count++;
                        queue.offer(new Pair<>(x+1, y));
                        queue.offer(new Pair<>(x+1, y+1));
                        queue.offer(new Pair<>(x, y+1));
                    }
                }
            }
            return count;
        }
    }

    @Test
    public void testBfsAllEnQueue() {
        SolutionV2020_BFS_AllEnQueue solutionV2020_bfs_allEnQueue = new SolutionV2020_BFS_AllEnQueue();
        System.out.println(solutionV2020_bfs_allEnQueue.movingCount(2, 3, 1));
        System.out.println(solutionV2020_bfs_allEnQueue.movingCount(3, 1, 0));
        System.out.println(solutionV2020_bfs_allEnQueue.movingCount(3, 2, 17));
        System.out.println(solutionV2020_bfs_allEnQueue.movingCount(11, 8, 16));
        System.out.println(solutionV2020_bfs_allEnQueue.movingCount(36, 11, 15));
    }
}

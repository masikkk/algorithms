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
 * @author si.ma
 * @create 2020-04-08 11:57
 */
public class _013_RobotMovingCount {
    private static class SolutionV2020DFS {
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
    public void testSolutionV2020() {
        SolutionV2020DFS solutionV2020DFS = new SolutionV2020DFS();
        System.out.println(solutionV2020DFS.movingCount(2, 3, 1));
        System.out.println(solutionV2020DFS.movingCount(3, 1, 0));
        System.out.println(solutionV2020DFS.movingCount(3, 2, 17));
        System.out.println(solutionV2020DFS.movingCount(11, 8, 16));
        System.out.println(solutionV2020DFS.movingCount(36, 11, 15));
    }

    private static class SolutionV2020BFS {
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
    public void testSolutionV2020BFS() {
        SolutionV2020BFS solutionV2020BFS = new SolutionV2020BFS();
        System.out.println(solutionV2020BFS.movingCount(2, 3, 1));
        System.out.println(solutionV2020BFS.movingCount(3, 1, 0));
        System.out.println(solutionV2020BFS.movingCount(3, 2, 17));
        System.out.println(solutionV2020BFS.movingCount(11, 8, 16));
        System.out.println(solutionV2020BFS.movingCount(36, 11, 15));
    }
}

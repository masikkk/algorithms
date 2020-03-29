package leetcode.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javafx.util.Pair;
import structs.ArrayUtils;

/**
 * @author masikkk.com
 * @create 2020-03-29 17:09
 */
public class _1162_AsFarFromLandAsPossible {
    private static class SolutionV2020 {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        public int maxDistance(int[][] grid) {
            int maxNearestDistance = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        maxNearestDistance = Math.max(maxNearestDistance, bfs(grid, i, j));
                    }
                }
            }
            return maxNearestDistance;
        }

        private int bfs(int[][] grid, int x, int y) {
            // 记录 (x,y) 是否已访问过，防止回退
            Set<Pair<Integer, Integer>> visited = new HashSet<>();

            Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(x, y));
            visited.add(new Pair<>(x, y));

            while (!queue.isEmpty()) {
                Pair<Integer, Integer> pair = queue.poll();
                // 上下左右
                for (int i = 0; i < 4; i++) {
                    int xx = pair.getKey() + dx[i], yy = pair.getValue() + dy[i];
                    Pair<Integer, Integer> newPair = new Pair<>(xx, yy);
                    if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length && !visited.contains(newPair)) {
                        if (grid[xx][yy] == 1) {
                            return Math.abs(xx - x) + Math.abs(yy - y);
                        } else {
                            visited.add(newPair);
                            queue.offer(new Pair<>(xx, yy));
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
//        String graph1 = "["
//                + "[1,0,1],"
//                + "[0,0,0],"
//                + "[1,0,1]]";
//        System.out.println(solutionV2020.maxDistance(ArrayUtils.stringToInt2DArray(graph1)));
//
//        String graph2 = "["
//                + "[1,0,0],"
//                + "[0,0,0],"
//                + "[0,0,0]]";
//        System.out.println(solutionV2020.maxDistance(ArrayUtils.stringToInt2DArray(graph2)));

        String graph3 = "["
                + "[1,1,1,1,1,1,1,1,1,1],"
                + "[1,0,0,0,0,0,0,0,0,1],"
                + "[1,0,0,0,0,0,0,0,0,1],"
                + "[1,0,0,0,0,0,0,0,0,1],"
                + "[1,0,0,0,0,0,0,0,0,1],"
                + "[1,0,0,0,0,0,0,0,0,1],"
                + "[1,0,0,0,0,0,0,0,0,1],"
                + "[1,0,0,0,0,0,0,0,0,1],"
                + "[1,0,0,0,0,0,0,0,0,1],"
                + "[1,1,1,1,1,1,1,1,1,1]]";
        System.out.println(solutionV2020.maxDistance(ArrayUtils.stringToInt2DArray(graph3)));

    }
}

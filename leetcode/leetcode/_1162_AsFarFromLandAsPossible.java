package leetcode.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
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
        // 记录已找到的最近距离
        Map<Pair<Integer, Integer>, Integer> map;

        public int maxDistance(int[][] grid) {
            map = new HashMap<>();
            int maxNearestDistance = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        int nearestDistance = bfs(grid, i, j);
                        map.put(new Pair<>(i, j), nearestDistance);
                        maxNearestDistance = Math.max(maxNearestDistance, nearestDistance);
                    }
                }
            }
            return maxNearestDistance;
        }

        private int bfs(int[][] grid, int x, int y) {
            // 记录 (x,y) 是否已访问过，防止回退
            Set<Pair<Integer, Integer>> set = new HashSet<>();

            Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(x, y));

            int nearestDistance = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> pair = queue.poll();
                set.add(pair);
                if (grid[pair.getKey()][pair.getValue()] == 1) {
                    int distance = distance(x, pair.getKey(), y, pair.getValue());
                    if (distance < nearestDistance) {
                        return distance;
                    }
                }
                // 上下左右
                for (int i = 0; i < 4; i++) {
                    int xx = pair.getKey() + dx[i], yy = pair.getValue() + dy[i];
                    Pair<Integer, Integer> newPair = new Pair<>(xx, yy);
                    if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length && !set.contains(newPair)) {
                        if (map.containsKey(newPair)) {
                            nearestDistance = Math.min(nearestDistance, map.get(newPair) + distance(x, xx, y, yy));
                        } else {
                            queue.offer(new Pair<>(xx, yy));
                        }
                    }
                }
            }
            return nearestDistance;
        }

        private int distance(int x1, int x2, int y1, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
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

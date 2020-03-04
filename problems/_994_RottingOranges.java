package problems;

import java.util.LinkedList;
import java.util.Queue;
import structs.ArrayUtils;

/**
 * @author masikkk.com
 * @create 2020-03-04 10:34
 */
public class _994_RottingOranges {
    private static class SolutionV2020 {
        public int orangesRotting(int[][] grid) {
            int nr = grid.length, nc = grid[0].length;

            // 连续腐烂区域的最大层次
            int maxLevels = 0;
            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    if (grid[i][j] == 2) {
                        int level = bfs(grid, i, j) - 1;
                        maxLevels = Math.max(maxLevels, level);
                    }
                }
            }

            // 若还有未腐烂的结点，返回-1
            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return maxLevels;
        }

        // 从 row,column 开始 BFS深度优先遍历grid中值为2的结点，并腐蚀值为1的点，返回bfs的层次
        private int bfs(int[][] grid, int row, int column) {
            int nr = grid.length, nc = grid[0].length;
            int levels = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(row * nc + column);
            while (!queue.isEmpty()) {
                levels++;
                int levelCount = queue.size();
                for (int i = 0; i < levelCount; i++) {
                    int seq = queue.poll();
                    row = seq / nc;
                    column = seq % nc;
                    // 访问结点，使其腐烂
                    grid[row][column] = 3;

                    // 结点上下左右的新鲜结点入队
                    if (row - 1 >= 0 && grid[row - 1][column] == 1) { // 上
                        queue.offer((row-1) * nc + column);
                    }
                    if (column + 1 < nc && grid[row][column + 1] == 1) { // 右
                        queue.offer((row) * nc + column + 1);
                    }
                    if (row + 1 < nr && grid[row + 1][column] == 1) { // 下
                        queue.offer((row+1) * nc + column);
                    }
                    if (column - 1 >= 0 && grid[row][column - 1] == 1) { // 左
                        queue.offer((row) * nc + column - 1);
                    }
                }
            }
            return levels;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        String input1 = "["
                + "[2,1,1],"
                + "[1,1,0],"
                + "[0,1,1]]";
        System.out.println(solutionV2020.orangesRotting(ArrayUtils.stringToInteger2DArray(input1)));

        String input2 = "["
                + "[2,1,1],"
                + "[0,1,1],"
                + "[1,0,1]]";
        System.out.println(solutionV2020.orangesRotting(ArrayUtils.stringToInteger2DArray(input2)));

        System.out.println(solutionV2020.orangesRotting(ArrayUtils.stringToInteger2DArray("[[0,2]]")));

        // 易错用例，两个2同时开始腐烂，只需2步即可
        System.out.println(solutionV2020.orangesRotting(ArrayUtils.stringToInteger2DArray("[[2],[1],[1],[1],[2],[1],[1]]")));
    }
}

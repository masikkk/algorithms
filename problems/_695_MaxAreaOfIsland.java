package problems;

import structs.ArrayUtils;

/**
 * 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 * @author masikkk.com
 * @create 2020-02-28 15:37
 */
public class _695_MaxAreaOfIsland {
    private static class SolutionV2020 {
        public int maxAreaOfIsland(int[][] grid) {
            if (null == grid || 0 == grid.length) {
                return 0;
            }
            int maxAres = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        int area = dfs(grid, i, j);
                        maxAres = Math.max(maxAres, area);
                    }
                }
            }
            return maxAres;
        }

        // 从i,j开始深度优先搜索，返回访问的1的个数
        private int dfs(int[][] grid, int i, int j) {
            int rows = grid.length, columns = grid[0].length;
            int count = 0;
            if (grid[i][j] == 1) {
                grid[i][j] = 0;
                count++;
                if (i - 1 >= 0 && grid[i - 1][j] == 1) { // 上
                    count += dfs(grid, i - 1, j);
                }
                if (j + 1 < columns && grid[i][j + 1] == 1) { // 右
                    count += dfs(grid, i, j + 1);
                }
                if (i + 1 < rows && grid[i + 1][j] == 1) { // 下
                    count += dfs(grid, i + 1, j);
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) { // 左
                    count += dfs(grid, i, j - 1);
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[][] grid = ArrayUtils.stringToIntegerArray(
                "[[0,0,1,0,0,0,0,1,0,0,0,0,0],"
                + " [0,0,0,0,0,0,0,1,1,1,0,0,0],"
                + " [0,1,1,0,1,0,0,0,0,0,0,0,0],"
                + " [0,1,0,0,1,1,0,0,1,0,1,0,0],"
                + " [0,1,0,0,1,1,0,0,1,1,1,0,0],"
                + " [0,0,0,0,0,0,0,0,0,0,1,0,0],"
                + " [0,0,0,0,0,0,0,1,1,1,0,0,0],"
                + " [0,0,0,0,0,0,0,1,1,0,0,0,0]]");
        System.out.println(solutionV2020.maxAreaOfIsland(grid));

        int[][] grid2 = ArrayUtils.stringToIntegerArray(
                "[[0,1,1],"
                    + " [0,1,0],"
                    + " [0,0,0,]]");
        System.out.println(solutionV2020.maxAreaOfIsland(grid2));

        int[][] grid3 = ArrayUtils.stringToIntegerArray("[[0,0,0,0,0,0,0,0]]");
        System.out.println(solutionV2020.maxAreaOfIsland(grid3));
    }
}

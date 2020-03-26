package leetcode.leetcode;

import structs.ArrayUtils;

/**
 * 网格内三维柱体的表面积
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 * @author masikkk.com
 * @create 2020-03-25 13:47
 */
public class _892_SurfaceAreaOf3DShapes {
    private static class SolutionV2020 {
        private int area;
        public int surfaceArea(int[][] grid) {
            if (null == grid || 0 == grid.length) {
                return 0;
            }

            this.area = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > 0) {
                        dfs(grid, i, j);
                    }
                }
            }
            return area;
        }

        // 从(x,y)开始一次dfs，过程中更新访问过点的表面积
        private void dfs(int[][] grid, int x, int y) {
            int rows = grid.length, columns = grid[0].length;
            if (x < 0 || y < 0 || x >= rows || y >= rows || grid[x][y] <= 0) {
                return;
            }
            // 访问 x,y
            area += 2; // 上下表面积

            // x,y 上右下左 的侧面积
            area += x - 1 >= 0 ? Math.max(0, grid[x][y] - Math.abs(grid[x - 1][y])) : grid[x][y];
            area += y + 1 < columns ? Math.max(0, grid[x][y] - Math.abs(grid[x][y + 1])) : grid[x][y];
            area += x + 1 < rows ? Math.max(0, grid[x][y] - Math.abs(grid[x+1][y])) : grid[x][y];
            area += y - 1 >= 0 ? Math.max(0, grid[x][y] - Math.abs(grid[x][y-1])) : grid[x][y];
            // 访问过的标为负值
            grid[x][y] = - grid[x][y];

            // 递归上右下左
            dfs(grid, x - 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.surfaceArea(ArrayUtils.stringToInt2DArray("[[2]]")));
        System.out.println(solutionV2020.surfaceArea(ArrayUtils.stringToInt2DArray("[[1,2],[3,4]]")));
        System.out.println(solutionV2020.surfaceArea(ArrayUtils.stringToInt2DArray("[[1,0],[0,2]]")));
        System.out.println(solutionV2020.surfaceArea(ArrayUtils.stringToInt2DArray("[[1,1,1],[1,0,1],[1,1,1]]")));
        System.out.println(solutionV2020.surfaceArea(ArrayUtils.stringToInt2DArray("[[2,2,2],[2,1,2],[2,2,2]]")));
    }
}

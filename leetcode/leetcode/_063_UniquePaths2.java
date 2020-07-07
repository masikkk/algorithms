package leetcode.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * @author masikkk.com
 * @create: 2020-07-06 21:06
 */
public class _063_UniquePaths2 {
    // 超时 27 / 41 个通过测试用例
    private static class SolutionV202007Backtrack {
        private Set<String> paths;
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            paths = new HashSet<>();
            backtrack(obstacleGrid, 0, 0, "");
            return paths.size();
        }

        private void backtrack(int[][] grid, int i, int j, String path) {
            if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
                return;
            }
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                paths.add(path);
                return;
            }
            // 向右走
            if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
                backtrack(grid, i, j + 1, path + "r");
            }
            // 向下走
            if (i + 1 < grid.length && grid[i + 1][j] == 0) {
                backtrack(grid, i + 1, j, path + "d");
            }
        }
    }

    public static void main(String[] args) {
        SolutionV202007Backtrack solutionV202007Backtrack = new SolutionV202007Backtrack();
        System.out.println(solutionV202007Backtrack.uniquePathsWithObstacles(new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
    }
}

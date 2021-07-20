package temp;

/**
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author masikkk.com
 * @create: 2020-07-23 23:05
 */
public class _064_MinimumPathSum {
    private static class SolutionV202007 {
        public int minPathSum(int[][] grid) {
            if (null == grid || grid.length < 1 || grid[0].length < 1) {
                return 0;
            }
            // dp[i][j] 表示 grid[i][j] 到右下角的最小路径和
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dp[i][j] = grid[i][j];
                    if (i + 1 < m && j + 1 < n) {
                        dp[i][j] += Math.min(dp[i + 1][j], dp[i][j + 1]);
                    } else if (i + 1 < m) {
                        dp[i][j] += dp[i + 1][j];
                    } else if (j + 1 < n) {
                        dp[i][j] += dp[i][j + 1];
                    }
                }
            }
            return dp[0][0];
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.minPathSum(new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}

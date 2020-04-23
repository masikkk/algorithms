package leetcode.crack;

import java.util.Arrays;

/**
 * 《程序员面试金典（第 6 版）》08.11 硬币
 * https://leetcode-cn.com/problems/coin-lcci/
 * @author masikkk.com
 * @create 2020-04-23 10:11
 */
public class _0811_Coin {
    private static class SolutionV2020 {
        public int waysToChange(int n) {
            int[] coin = {1, 5, 10, 25};
            // dp[i][j] 表示用前 i 个硬币构成面值 j 的方案数，则有 dp[i][j] = dp[i-1][j] + dp[i][j-ci] , ci表示第i个硬币的面值
            int[][] dp = new int[5][n + 1];
            // 硬币1组成任意金额的方案只有1种
            Arrays.fill(dp[1], 1);
            // 不管多少个硬币，组成面值0的方案只有1种
            for (int i = 1; i <= 4; i++) {
                dp[i][0] = 1;
            }
            for (int i = 2; i <= 4; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j < coin[i - 1]) {
                        dp[i][j] = dp[i - 1][j] % 1000000007;
                    } else {
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - coin[i - 1]]) % 1000000007;
                    }
                }
            }
            return dp[4][n];
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.waysToChange(5));
        System.out.println(solutionV2020.waysToChange(10));
        // 结果需要对 1000000007 取模
        System.out.println(solutionV2020.waysToChange(900750));
    }
}

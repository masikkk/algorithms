package leetcode.leetcode;

/**
 * 戳气球
 * https://leetcode-cn.com/problems/burst-balloons/
 * @author masikkk.com
 * @create: 2020-07-19 20:18
 */
public class _312_BurstBalloons {
    private static class SolutionV202007 {
        public int maxCoins(int[] nums) {
            // 扩展原数组为 nums2 ，收尾增加值 1，方便计算
            int[] nums2 = new int[nums.length + 2];
            nums2[0] = 1;
            nums2[nums2.length - 1] = 1;
            for (int i = 0; i < nums.length; i++) {
                nums2[i + 1] = nums[i];
            }
            // dp[i][j] 表示开区间 (i,j) 能得到的最大金币数
            // 则 dp[i][j] = max_{i<k<j}{dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j]}, 且 dp[0][nums2.length - 1] 就是最终结果
            int[][] dp = new int[nums2.length][nums2.length]; // 默认初始值都是 0

            // 遍历填表，由于 dp[i][j] 依赖于 dp[k][j] 而 k > i，即第 i 行的结果依赖行数大于 i 的结果，所以要 i 要从 nums2.length-1 开始递减遍历
            for (int i = nums2.length - 2; i >= 0; i--) {
                for (int j = 0; j < nums2.length; j++) {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j]);
                    }
                }
            }
            return dp[0][nums2.length - 1];
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.maxCoins(new int[] {3,1,5,8}));
    }
}

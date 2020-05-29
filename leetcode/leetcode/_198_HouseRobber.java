package leetcode.leetcode;

/**
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @author masikkk.com 2020-05-29 16:14
 */
public class _198_HouseRobber {
    private static class SolutionV202005 {
        public int rob(int[] nums) {
            // 特殊处理数组长度小于 3 的情况
            if (null == nums || nums.length < 1) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            // dp[i] 表示抢劫 nums[0...i] 能获得的最大收益，则 dp[i] = max(dp[i-2] + nums[i], dp[i-1])
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.rob(new int[] {1,2,3,1}));
        System.out.println(solutionV202005.rob(new int[] {2,7,9,3,1}));
    }
}
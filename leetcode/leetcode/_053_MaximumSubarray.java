package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 最大子序列和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author madaimeng.com
 */
public class _053_MaximumSubarray {
    private static class SolutionV202002 {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int sum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                sum = sum > 0 ? sum + nums[i] : nums[i];
                if (sum > max) {
                    max = sum;
                }
            }
            return max;
        }
    }

    @Test
    public void testSolutionV202002() {
        SolutionV202002 solutionV202002 = new SolutionV202002();
        System.out.println(solutionV202002.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    private static class SolutionV202005 {
        public int maxSubArray(int[] nums) {
            if (null == nums || nums.length == 0) {
                return 0;
            }
            int max = nums[0];
            // sum[i] 表示 nums[0...i] 中以 nums[i] 为结尾的连续子数组的最大和
            // 则 sum[i] = sum[i-1] + nums[i] if sum[i-1] > 0, or sum[i] = nums[i]
            int[] sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i - 1 >= 0 && sum[i - 1] > 0) {
                    sum[i] = sum[i - 1] + nums[i];
                } else {
                    sum[i] = nums[i];
                }
                max = Math.max(max, sum[i]);
            }
            return max;
        }
    }

    @Test
    public void testSolutionV202005() {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solutionV202005.maxSubArray(new int[] {-1}));
        System.out.println(solutionV202005.maxSubArray(new int[] {1,2}));
    }
}

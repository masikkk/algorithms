package leetcode.leetcode;

import java.util.Optional;

/**
 * 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @author masikkk.com 2020-06-28 14:29
 */
public class _209_MinimumSizeSubarraySum {
    private static class SolutionV202006 {
        public int minSubArrayLen(int s, int[] nums) {
            if (null == nums || nums.length < 1) {
                return 0;
            }
            Integer minLength = null;
            int sum = 0;
            for (int left = 0, right = 0; right < nums.length; right++) {
                sum += nums[right]; // 扩张右边界
                while (sum >= s) { // 收缩左边界
                    minLength = minLength == null ? right - left + 1 : Math.min(minLength, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return Optional.ofNullable(minLength).orElse(0);
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(solutionV202006.minSubArrayLen(3, new int[] {1,1}));
    }
}
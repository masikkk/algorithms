/**
 * 最大子序列和
 * @author madaimeng.com
 * @create: 2019-12-02 20:35
 */
public class _053_MaximumSubarrayV2019 {
    private static class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}

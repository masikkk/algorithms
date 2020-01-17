/**
 * 最大子序列和
 * @author madaimeng.com
 * @create: 2019-12-02 20:35
 */
public class _053_MaximumSubarray {
    private static class SolutionV2020 {
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
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solutionV2020.maxSubArray(nums));
    }
}

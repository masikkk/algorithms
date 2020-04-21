package leetcode.leetcode;

/**
 * 统计「优美子数组」
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * @author masikkk.com 2020-04-21 11:55
 */
public class _1248_CountNumberOfNiceSubarrays {
    // 暴力，超时，23 / 38 个通过测试用例
    private static class SolutionV2020Brutal {
        public int numberOfSubarrays(int[] nums, int k) {
            if (null == nums || nums.length < k) {
                return 0;
            }
            int res = 0;

            for (int i = 0; i <= nums.length - k; i++) {
                // 统计以 nums[i] 开头的连续子数组的奇数个数
                int oddCount = 0;
                for (int j = i; j < nums.length; j++) {
                    if ((nums[j] & 1) == 1) {
                        oddCount++;
                    }
                    if (oddCount == k) {
                        res++;
                    } else if (oddCount > k) {
                        break;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020Brutal solutionV2020Brutal = new SolutionV2020Brutal();
        System.out.println(solutionV2020Brutal.numberOfSubarrays(new int[] {1,1,2,1,1}, 3));
        System.out.println(solutionV2020Brutal.numberOfSubarrays(new int[] {2,4,6}, 1));
        System.out.println(solutionV2020Brutal.numberOfSubarrays(new int[] {2,2,2,1,2,2,1,2,2,2}, 2));
    }
}
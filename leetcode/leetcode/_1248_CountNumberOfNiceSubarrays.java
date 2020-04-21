package leetcode.leetcode;

import org.junit.jupiter.api.Test;

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

    @Test
    public void testSolutionV2020Brutal() {
        SolutionV2020Brutal solutionV2020Brutal = new SolutionV2020Brutal();
        System.out.println(solutionV2020Brutal.numberOfSubarrays(new int[] {1,1,2,1,1}, 3));
        System.out.println(solutionV2020Brutal.numberOfSubarrays(new int[] {2,4,6}, 1));
        System.out.println(solutionV2020Brutal.numberOfSubarrays(new int[] {2,2,2,1,2,2,1,2,2,2}, 2));
        System.out.println(solutionV2020Brutal.numberOfSubarrays(new int[] {2,2,1,1,2,2,1,1,2,2}, 2));
    }

    private static class SolutionV2020 {
        public int numberOfSubarrays(int[] nums, int k) {
            if (null == nums || nums.length < k) {
                return 0;
            }
            // 原数组中所有奇数的下标
            int[] odds = new int[nums.length];
            int oddsCount = 0;
            for(int i = 0, j = 0; i < nums.length; i++) {
                if ((nums[i] & 1) == 1) {
                    odds[oddsCount++] = i;
                }
            }
            int res = 0;
            for (int i = 0; i <= oddsCount - k; i++) {
                // 左边界有多少种扩展，也就是左边界和上一个奇数之间的偶数个数+1
                int leftCount = i-1 >= 0 ? odds[i] - odds[i-1] : odds[i] + 1;
                // 右边界有多少种扩展，也就是右边界和下一个奇数之间的偶数个数+1
                int rightCount = i+k < oddsCount ? odds[i+k] - odds[i+k-1] : nums.length - odds[i+k-1];
                // 左边界扩展个数 * 右边界扩展个数，也就是第i个奇数开头的奇数个数为k的子数组能贡献的个数
                res += leftCount * rightCount;
            }
            return res;
        }
    }

    @Test
    public void testSolutionV2020() {
        SolutionV2020 solutionV2020 =  new SolutionV2020();
        System.out.println(solutionV2020.numberOfSubarrays(new int[] {1,1,2,1,1}, 3));
        System.out.println(solutionV2020.numberOfSubarrays(new int[] {2,4,6}, 1));
        System.out.println(solutionV2020.numberOfSubarrays(new int[] {2,2,2,1,2,2,1,2,2,2}, 2));
        System.out.println(solutionV2020.numberOfSubarrays(new int[] {2,2,1,1,2,2,1,1,2,2}, 2));
    }
}
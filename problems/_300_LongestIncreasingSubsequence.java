package problems;

import structs.ListNode;

/**
 * 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author masikkk.com
 * @create 2020-03-14 13:28
 */
public class _300_LongestIncreasingSubsequence {
    private static class SolutionV2020 {
        public int lengthOfLIS(int[] nums) {
            if (null == nums) {
                return 0;
            }
            if (nums.length < 2) {
                return nums.length;
            }
            // lis[i] 表示 0, ... i-1 中 最长上升子序列的长度
            int[] lis = new int[nums.length];
            // lis 的最大值
            int max = 0;
            // 找 nums[i] 之前比 nums[i] 小的数中的 lis 最大值
            for (int i = 1; i < nums.length; i++) {
                boolean update = false;
                int preLessMax = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i]) {
                        update = true;
                        preLessMax = Math.max(preLessMax, lis[j]);
                    }
                }
                if (update) {
                    lis[i] = preLessMax + 1;
                    max = Math.max(max, lis[i]);
                }
            }
            return max + 1;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.lengthOfLIS(ListNode.stringToIntegerArray("[10,9,2,5,3,7,101,18]")));
        System.out.println(solutionV2020.lengthOfLIS(ListNode.stringToIntegerArray("[10]")));
        System.out.println(solutionV2020.lengthOfLIS(ListNode.stringToIntegerArray("[10,11,1,9,2,3,12]")));
        System.out.println(solutionV2020.lengthOfLIS(ListNode.stringToIntegerArray("[2,2]")));
        System.out.println(solutionV2020.lengthOfLIS(ListNode.stringToIntegerArray("[1,3,6,7,9,4,10,5,6]")));
    }
}

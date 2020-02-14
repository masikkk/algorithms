package problems;

import structs.ListNode;

/**
 * 数组中缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 * @author masikkk.com
 */
public class _041_FirstMissingPositive {
    private static class SolutionV2020 {
        public int firstMissingPositive(int[] nums) {
            if (null == nums || nums.length == 0) {
                return 1;
            }
            // 把所有非正数替换为 n+1
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0) {
                    nums[i] = nums.length + 1;
                }
            }
            // 用数组下标法把 1≤a[i]≤n 的数标为已存在
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[i]) >= 1 && Math.abs(nums[i]) <= nums.length) {
                    nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
                }
            }
            // 找第一个不存在的下标，就是缺失的最小正数
            int i = 0;
            for (; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return i + 1;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.firstMissingPositive(ListNode.stringToIntegerArray("[1,2,0]")));
        System.out.println(solutionV2020.firstMissingPositive(ListNode.stringToIntegerArray("[3,4,-1,1]")));
        System.out.println(solutionV2020.firstMissingPositive(ListNode.stringToIntegerArray("[7,8,9,11,12]")));
    }
}

package leetcode.crack;

import structs.ListNode;

/**
 * 《程序员面试金典（第 6 版）》17.16 按摩师
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 * @author masikkk.com
 * @create 2020-03-24 10:11
 */
public class _1716_Masseuse {
    private static class SolutionV2020 {
        public int massage(int[] nums) {
            if (null == nums || 0 == nums.length) {
                return 0;
            }
            // include[i]: nums[0...i] 中包含 nums[i] 在内的最大值
            int[] include = new int[nums.length];
            // exclude[i]: nums[0...i] 中不包含 nums[i] 在内的最大值
            int[] exclude = new int[nums.length];
            include[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                include[i] = exclude[i - 1] + nums[i];
                exclude[i] = Math.max(include[i - 1], exclude[i - 1]);
            }
            return Math.max(include[nums.length - 1], exclude[nums.length - 1]);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.massage(ListNode.stringToIntegerArray("[1,2,3,1]")));
        System.out.println(solutionV2020.massage(ListNode.stringToIntegerArray("[2,7,9,3,1]")));
        System.out.println(solutionV2020.massage(ListNode.stringToIntegerArray("[2,1,4,5,3,1,1,3]")));
        System.out.println(solutionV2020.massage(ListNode.stringToIntegerArray("[1,2]")));
        System.out.println(solutionV2020.massage(ListNode.stringToIntegerArray("[1]")));
        System.out.println(solutionV2020.massage(ListNode.stringToIntegerArray("[1,5,1]")));
        System.out.println(solutionV2020.massage(ListNode.stringToIntegerArray("[3,4,2]")));
    }
}

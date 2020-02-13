package problems;

import structs.ListNode;

/**
 * 数组中重复的数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @author masikkk.com
 * @create 2020-02-12 22:41
 */
public class _287_FindTheDuplicateNumber {
    private static class SolutionV2020 {
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[slow];
            // 找环交点
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
                fast = nums[fast];
            }
            // 找环入口
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findDuplicate(ListNode.stringToIntegerArray("[1,3,4,2,2]")));
        System.out.println(solutionV2020.findDuplicate(ListNode.stringToIntegerArray("[3,1,3,4,2]")));
        System.out.println(solutionV2020.findDuplicate(ListNode.stringToIntegerArray("[1,1,1,1,2]")));
        System.out.println(solutionV2020.findDuplicate(ListNode.stringToIntegerArray("[2,5,9,6,9,3,8,9,7,1]")));
    }
}

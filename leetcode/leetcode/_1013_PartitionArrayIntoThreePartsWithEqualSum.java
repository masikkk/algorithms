package leetcode.leetcode;

import structs.ListNode;

/**
 * 将数组分成和相等的三个部分
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * @author masikkk.com
 * @create 2020-03-11 16:02
 */
public class _1013_PartitionArrayIntoThreePartsWithEqualSum {
    private static class SolutionV2020 {
        public boolean canThreePartsEqualSum(int[] nums) {
            if (null == nums || nums.length < 3) {
                return false;
            }
            int sum = 0; // 总和
            for (int n : nums) {
                sum += n;
            }
            if (sum % 3 != 0) { // 无法分为sum相等的3部分
                return false;
            }
            int targetPartSum = sum / 3;
            int left = 0, right = nums.length - 1;
            int leftSum = nums[left], rightSum = nums[right];
            while (left + 1 < right) {
                int midSum = sum - leftSum - rightSum; // 中间部分的和
                if (midSum == leftSum && midSum == rightSum) {
                    // 3部分和相等，结束
                    System.out.println(left + ": " + nums[left] + ", " + right + ": " + nums[right]);
                    return true;
                }
                if (leftSum != targetPartSum) {
                    left++;
                    leftSum += nums[left];
                }
                if (rightSum != targetPartSum) {
                    right--;
                    rightSum += nums[right];
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.canThreePartsEqualSum(ListNode.stringToIntegerArray("[1,1,1]")));
        System.out.println(solutionV2020.canThreePartsEqualSum(ListNode.stringToIntegerArray("[0,2,1,-6,6,-7,9,1,2,0,1]")));
        System.out.println(solutionV2020.canThreePartsEqualSum(ListNode.stringToIntegerArray("[0,2,1,-6,6,7,9,-1,2,0,1]")));
        System.out.println(solutionV2020.canThreePartsEqualSum(ListNode.stringToIntegerArray("[3,3,6,5,-2,2,5,1,-9,4]")));
        System.out.println(solutionV2020.canThreePartsEqualSum(ListNode.stringToIntegerArray("[18,12,-18,18,-19,-1,10,10]")));
        System.out.println(solutionV2020.canThreePartsEqualSum(ListNode.stringToIntegerArray("[-1,-1,-1]")));
        System.out.println(solutionV2020.canThreePartsEqualSum(ListNode.stringToIntegerArray("[1,-1,1,-1]")));
        System.out.println(solutionV2020.canThreePartsEqualSum(ListNode.stringToIntegerArray("[10,-10,10,-10,10,-10,10,-10]")));
    }
}

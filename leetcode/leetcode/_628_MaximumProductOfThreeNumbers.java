package leetcode.leetcode;

import structs.ListNode;

/**
 * 数组中三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @author masikkk.com
 * @create 2020-02-04 15:32
 */
public class _628_MaximumProductOfThreeNumbers {
    private static class SolutionV2020 {
        public int maximumProduct(int[] nums) {
            // 最大值，次大值，3大值
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            // 最小值、次小值
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                } else if (nums[i] > max2) {
                    max3 = max2;
                    max2 = nums[i];
                } else if (nums[i] > max3) {
                    max3 = nums[i];
                }
                if (nums[i] < min1) {
                    min2 = min1;
                    min1 = nums[i];
                } else if (nums[i] < min2) {
                    min2 = nums[i];
                }
            }
            return Math.max(max1 * max2 * max3, min1 * min2 * max1);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.maximumProduct(ListNode.stringToIntegerArray("[1,2,3]")));
        System.out.println(solutionV2020.maximumProduct(ListNode.stringToIntegerArray("[1,2,2,-1,5,-2,-10]")));
        // 易错用例
        System.out.println(solutionV2020.maximumProduct(ListNode.stringToIntegerArray("[1,1,1]")));
        // 易错用例
        System.out.println(solutionV2020.maximumProduct(ListNode.stringToIntegerArray("[-1,-2,-3]")));
    }
}

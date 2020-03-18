package leetcode.leetcode;

import java.util.Arrays;
import structs.ListNode;

/**
 * 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * @author masikkk.com
 * @create 2020-02-08 11:11
 */
public class _238_ProductOfArrayExceptSelf {
    private static class SolutionV2020 {
        public int[] productExceptSelf(int[] nums) {
            int size = nums.length;
            // left[i]: nums[i]左边所有元素乘积
            int[] left = new int[size];
            // right[i]: nums[i]右边所有元素乘积
            int[] right = new int[size];
            int leftProduct = 1, rightProduct = 1;
            for (int i = 0; i < size; i++) {
                left[i] = leftProduct;
                leftProduct *= nums[i];
                right[size - i -1] = rightProduct;
                rightProduct *= nums[size - i -1];
            }
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = left[i] * right[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(
                solutionV2020.productExceptSelf(ListNode.stringToIntegerArray("[1,2,3,4]"))));
        System.out.println(Arrays.toString(
                solutionV2020.productExceptSelf(ListNode.stringToIntegerArray("[1,2]"))));
    }
}

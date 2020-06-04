package leetcode.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import structs.ListNode;

/**
 * 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * @author masikkk.com
 * @create 2020-02-08 11:11
 */
public class _238_ProductOfArrayExceptSelf {
    private static class SolutionV202002 {
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

    @Test
    public void testSolutionV202002() {
        SolutionV202002 solutionV202002 = new SolutionV202002();
        System.out.println(Arrays.toString(solutionV202002.productExceptSelf(ListNode.stringToIntegerArray("[1,2,3,4]"))));
        System.out.println(Arrays.toString(solutionV202002.productExceptSelf(ListNode.stringToIntegerArray("[1,2]"))));
    }

    private static class SolutionV202006 {
        public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            // 先将 后缀积 放入 res 中，即 res[i] = res[i+1] * ... * res[nums.length - 1]
            res[nums.length - 1] = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                res[i] = nums[i + 1] * res[i + 1];
            }

            // 前缀积
            int preProduct = 1;
            for (int i = 0; i < nums.length; i++) {
                res[i] = preProduct * res[i];
                preProduct *= nums[i];
            }
            return res;
        }
    }

    @Test
    public void testSolutionV202006() {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(Arrays.toString(solutionV202006.productExceptSelf(ListNode.stringToIntegerArray("[1,2,3,4]"))));
        System.out.println(Arrays.toString(solutionV202006.productExceptSelf(ListNode.stringToIntegerArray("[1,2]"))));
    }
}

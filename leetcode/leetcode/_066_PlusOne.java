package leetcode.leetcode;

import java.util.Arrays;
import structs.ListNode;

/**
 * 数组加一
 * https://leetcode-cn.com/problems/plus-one/
 * @author masikkk.com
 * @create 2020-02-09 14:27
 */
public class _066_PlusOne {
    private static class SolutionV2020 {
        public int[] plusOne(int[] digits) {
            if (null == digits || 0 == digits.length) {
                return digits;
            }
            int[] res = new int[digits.length + 1];
            int carry = 1, remain = 0;
            for (int i = digits.length -1; i >= 0; i--) {
                remain = (digits[i] + carry) % 10; // 余数
                carry = (digits[i] + carry) / 10; // 进位
                digits[i] = remain;
                res[i] = remain;
            }
            if (carry != 0) {
                res[0] = carry;
                return res;
            } else {
                return digits;
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(
                solutionV2020.plusOne(ListNode.stringToIntegerArray("[1,2,3]"))));
        System.out.println(Arrays.toString(
                solutionV2020.plusOne(ListNode.stringToIntegerArray("[9,9,9]"))));
    }
}

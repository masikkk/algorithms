package leetcode.leetcode;

import java.util.Arrays;
import structs.ListNode;

/**
 * 数组中只出现一次的数3
 * https://leetcode-cn.com/problems/single-number-iii/
 * @author masikkk.com
 * @create 2020-02-15 16:37
 */
public class _260_SingleNumber3 {
    private static class SolutionV2020 {
        public int[] singleNumber(int[] nums) {
            // 所有数异或，结果是仅出现一次的2个数a、b的异或值
            int xor = 0;
            for (int n : nums) {
                xor ^= n;
            }
            // lowbit是所有数异或结果仅保留最低位1其余全是0对应的值，a、b在此位上异或结果为1说明a、b在此位的值肯定不同，那么我们就可以利用此位将a、b两数分开
            int lowbit = xor & (-xor);
            // 所有数和lowbit按位与，根据在此位是1还是0分到两个子数组中，则a、b肯定分到了不同的子数组，同值的肯定也都在同一个子数组
            // 则问题转变为两个 "数组中所有值都出现2次只有一个值出现1次" 的问题，子数组所有值异或可分别得到a、b值
            int a = 0, b = 0;
            for (int n : nums) {
                if ((n & lowbit) == 0) {
                    a ^= n;
                } else {
                    b ^= n;
                }
            }
            int[] res = new int[]{a, b};
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(solutionV2020.singleNumber(ListNode.stringToIntegerArray("[1,2,1,3,2,5]"))));
    }
}

package leetcode.leetcode;

import structs.ListNode;

/**
 * 数组中只出现一次的数2
 * https://leetcode-cn.com/problems/single-number-ii/
 * @author masikkk.com
 * @create 2020-02-12 10:28
 */
public class _137_SingleNumber2 {
    private static class SolutionV2020 {
        public int singleNumber(int[] nums) {
            int res = 0;
            // 所有元素在每位上的和对3求余，结果就是唯一数在此位的值
            for (int i = 0; i < 32; i++) {
                int bitSum = 0;
                for(int j = 0; j < nums.length; j++) {
                    bitSum += nums[j] & 1;
                    nums[j] >>= 1;
                }
                res |= (bitSum % 3) << i;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.singleNumber(ListNode.stringToIntegerArray("[2,2,3,2]")));
        System.out.println(solutionV2020.singleNumber(ListNode.stringToIntegerArray("[0,1,0,1,0,1,99]")));
        System.out.println(solutionV2020.singleNumber(ListNode.stringToIntegerArray("[2,2,-3,2]")));
    }
}

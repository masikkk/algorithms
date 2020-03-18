package leetcode.leetcode;

import structs.ListNode;

/**
 * 不变数组的范围和
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @author masikkk.com
 * @create 2020-02-09 10:45
 */
public class _303_RangeSumQueryImmutable {
    private static class NumArray {
        // 累加和
        private int[] sum;

        public NumArray(int[] nums) {
            if (null == nums || nums.length == 0) {
                sum = null;
                return;
            }
            sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        // sum[i->j] = sum[j] - sum[i-1]
        public int sumRange(int i, int j) {
            return sum[j] - (i - 1 >= 0 ? sum[i - 1] : 0);
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(ListNode.stringToIntegerArray("[-2, 0, 3, -5, 2, -1]"));
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}

package leetcode.offer;

import java.util.Arrays;

/**
 * 《剑指offer》面试题56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @author masikkk.com 2020-04-28 13:52
 */
public class _056_TwoSingleNumber {
    private static class SolutionV2020 {
        public int[] singleNumbers(int[] nums) {
            if (null == nums || nums.length < 2) {
                return nums;
            }
            // 所有元素的异或，就等于出现1次的两个数的异或
            int xor = nums[0];
            for (int i = 1; i < nums.length; i++) {
                xor ^= nums[i];
            }
            // 获取 xor 的最低位1其余全0对应的整数，牢记这个公式
            int lowest1 = xor & (-xor);
            // 根据 nums[i] 在 lowest1 位上是1还是0把数组中的数分为2组同时做异或，出现次数为1的两个数肯定在不同组中，其他的相同的元素肯定在同一组中
            int group1 = 0, group2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((lowest1 & nums[i]) == lowest1) {
                    group1 ^= nums[i];
                } else {
                    group2 ^= nums[i];
                }
            }
            return new int[] {group1, group2};
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(solutionV2020.singleNumbers(new int[] {4,1,4,6})));
        System.out.println(Arrays.toString(solutionV2020.singleNumbers(new int[] {1,2,10,4,1,4,3,3})));
    }
}
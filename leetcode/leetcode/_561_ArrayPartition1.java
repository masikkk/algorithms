package leetcode.leetcode;

import java.util.Arrays;

/**
 * 数组拆分 I
 * https://leetcode-cn.com/problems/array-partition-i/
 */
public class _561_ArrayPartition1 {
    private static class SolutionV2018 {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);//正序排序
            int sum = 0;
            for (int i = 0; i < nums.length; ) {
                sum += nums[i];
                i = i + 2;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.arrayPairSum(new int[] {1, 4, 3, 2}));
    }
}

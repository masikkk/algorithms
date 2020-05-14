package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class _136_SingleNumber {
    private static class SolutionV2018 {
        public int singleNumber(int[] nums) {
            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result = result ^ nums[i];//异或
            }
            return result;
        }
    }

    @Test
    public void testSolutionV2018() {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.singleNumber(new int[] {1, 2, 3, 4, 5, 4, 3, 2, 1}));
    }
}

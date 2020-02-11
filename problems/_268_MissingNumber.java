package problems;

import structs.ListNode;

/**
 * 连续数组中缺失的数
 * https://leetcode-cn.com/problems/missing-number/
 * @author masikkk.com
 * @create 2020-02-11 21:58
 */
public class _268_MissingNumber {
    private static class SolutionV2020 {
        public int missingNumber(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
               res ^= nums[i];
               res ^= i+1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.missingNumber(ListNode.stringToIntegerArray("[3,0,1]")));
        System.out.println(solutionV2020.missingNumber(ListNode.stringToIntegerArray("[9,6,4,2,3,5,7,0,1]")));
    }
}

package problems;

import java.util.Arrays;
import structs.ListNode;

/**
 * 找出数组中重复的数和缺失的数
 * https://leetcode-cn.com/problems/set-mismatch/
 * @author masikkk.com
 * @create 2020-02-13 22:22
 */
public class _645_SetMismatch {
    private static class SolutionV2020 {
        public int[] findErrorNums(int[] nums) {
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                // 重复的值
                if (nums[Math.abs(nums[i]) - 1] < 0) {
                    res[0] = Math.abs(nums[i]);
                } else {
                    // 已出现值的下标改为负的
                    nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                // 值为正的表示他的下标没出现过
                if (nums[i] > 0) {
                    res[1] = i + 1;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(solutionV2020.findErrorNums(ListNode.stringToIntegerArray("[1,2,2,4]"))));
        System.out.println(Arrays.toString(solutionV2020.findErrorNums(ListNode.stringToIntegerArray("[2,3,2]"))));
    }
}

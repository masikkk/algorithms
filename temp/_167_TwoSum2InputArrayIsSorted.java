package temp;

import java.util.Arrays;

/**
 * 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author masikkk.com
 * @create: 2020-07-20 21:16
 */
public class _167_TwoSum2InputArrayIsSorted {
    private static class SolutionV202007 {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == target) {
                    break;
                }
                if (numbers[left] + numbers[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[] {left + 1, right + 1};
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(Arrays.toString(solutionV202007.twoSum(new int[] {2, 7, 11, 15}, 9)));
    }
}

package leetcode.leetcode;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class _026_RemoveDuplicatesFromSortedArray {
    private static class SolutionV2018 {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int slow = 0, fast = 0;
            for (; fast < nums.length - 1; ) {
                if (nums[fast] != nums[fast + 1]) {
                    nums[slow++] = nums[fast++];
                } else {
                    fast++;
                }
            }
            nums[slow++] = nums[fast];
            return slow;
        }
    }

    private static class SolutionV2020 {
        public int removeDuplicates(int[] nums) {
            if (null == nums) {
                return 0;
            }
            if (nums.length < 2) {
                return nums.length;
            }
            int left = 0;
            for (int right = 1; right < nums.length; right++) {
                if (nums[right - 1] != nums[right]) {
                    nums[++left] = nums[right];
                }
            }
            return left + 1;
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println("SolutionV2018:");
        int[] input = {1, 1, 1, 2, 33, 44, 44};
        System.out.println(solutionV2018.removeDuplicates(input) + ": " + Arrays.toString(input));

        System.out.println("SolutionV2020:");
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[] input2 = {1, 1, 1, 2, 33, 44, 44};
        System.out.println(solutionV2020.removeDuplicates(input2) + ": " + Arrays.toString(input2));
        int[] input3 = {1, 1};
        System.out.println(solutionV2020.removeDuplicates(input3) + ": " + Arrays.toString(input3));
        int[] input4 = {1, 2};
        System.out.println(solutionV2020.removeDuplicates(input4) + ": " + Arrays.toString(input4));
        int[] input5 = {1, 1, 1, 2, 33, 44, 44, 44, 44};
        System.out.println(solutionV2020.removeDuplicates(input5) + ": " + Arrays.toString(input5));
    }
}

package problems;

import java.util.Arrays;

/**
 * 将数组中的零移到末尾
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _283_MoveZeroes {
    private static class SolutionV2018 {
        //仿冒泡排序法，O(n^2)
        public void moveZeroes(int[] nums) {
            boolean swaped = true;//上次循环是否有过交换
            for (int i = 1; i < nums.length && swaped; i++) {
                swaped = false;
                for (int j = 0; j < nums.length - i; j++) {
                    if (nums[j] == 0 && nums[j + 1] != 0) {//交换
                        swaped = true;
                        nums[j] = nums[j] ^ nums[j + 1];
                        nums[j + 1] = nums[j] ^ nums[j + 1];
                        nums[j] = nums[j] ^ nums[j + 1];
                    }
                }
            }
        }

        //双指针，O(n)
        public void moveZeroes2(int[] nums) {
            int leftMostZeroIndex = 0; // The index of the leftmost zero
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (i > leftMostZeroIndex) { // There are zero(s) on the left side of the current non-zero number, swap!
                        nums[leftMostZeroIndex] = nums[i];
                        nums[i] = 0;
                    }
                    leftMostZeroIndex++;
                }
            }
        }
    }

    private static  class SolutionV2020 {
        public void moveZeroes(int[] nums) {
            if (null == nums || nums.length < 2) {
                return;
            }
            // left左边是要保留的非零元素
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] != 0) {
                    if (right != left) {
                        nums[left] = nums[right];
                    }
                    left++;
                }
            }
            // left右边的元素置为0
            while (left < nums.length) {
                nums[left++] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println("SolutionV2018:");
        int[] nums = {0, 1, 0, 3, 12};
        solutionV2018.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println("SolutionV2020:");
        int[] nums2 = {0,0,1, 0};
        solutionV2020.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}

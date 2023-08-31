package sort;

import java.util.Arrays;
import utils.ArrayUtils;

/**
 * 冒泡排序，O(n^2)，稳定
 *
 * @author masikkk.com
 * @create 2020-02-24 11:48
 */
public class BubbleSort {
    private static class SolutionV2020 {
        public static void sort(int[] nums) {
            if (null == nums || 0 == nums.length) {
                return;
            }
            // 上次循环是否交换过，若无交换说明排序已完成
            boolean changed = true;
            for (int i = 1; i < nums.length; i++) {
                if (changed) {
                    changed = false;
                    for (int j = 0; j < nums.length - i; j++) {
                        if (nums[j] > nums[j + 1]) {
                            changed = true;
                            int temp = nums[j + 1];
                            nums[j + 1] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
            }
        }
    }

    private static class SolutionV2023 {
        public static void sort(int[] array) {
            if (null == array || array.length == 0) {
                return;
            }
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtils.randomIntArray(12);
        System.out.println(Arrays.toString(nums));
        SolutionV2023.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

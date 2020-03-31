package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static int[] sort(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void qsort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int location = partition(nums, left, right);
        qsort(nums, left, location - 1);
        qsort(nums, location + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(QuickSort.sort(new int[] {4, 13, 2, 8, 1, 5, 1})));
        System.out.println(Arrays.toString(QuickSort.sort(new int[] {5,2,3,1})));
        System.out.println(Arrays.toString(QuickSort.sort(new int[] {5,1,1,2,0,0})));
        System.out.println(Arrays.toString(QuickSort.sort(new int[] {5,1})));
        System.out.println(Arrays.toString(QuickSort.sort(new int[] {1,5})));
        System.out.println(Arrays.toString(QuickSort.sort(new int[] {1,2,3,4,5})));
    }
}

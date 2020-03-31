package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    // 快速排序
    public static int[] sort(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    // 递归对 nums[left,...,right] 进行快速排序
    private static void qsort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int location = partition(nums, left, right);  // 将数组分为两部分
        qsort(nums, left, location - 1); // 递归排序左子数组
        qsort(nums, location + 1, right); // 递归排序右子数组
    }

    // 进行一次partition，选nums[left]为枢轴，小于枢轴的放左边，大于枢轴的放右边，返回枢轴的位置
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left]; // 选第一个数为枢轴
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right]; // 交换比枢轴小的记录到左端
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left]; // 交换比枢轴小的记录到右端
        }
        // 枢轴归位
        nums[left] = pivot;
        return left; // 返回枢轴的位置
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

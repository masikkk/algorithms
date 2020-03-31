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
        // 从nums[left,...,right]中随机找一个数放到 left 下标的位置
//        randomFirst(nums, left, right);
        // 找 left,mid,right 中间的数放到 left 下标的位置
        middleFirst(nums, left, right);
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

    // 从nums[left,...,right]中随机找一个数放到 left 下标的位置
    private static void randomFirst(int[] nums, int left, int right) {
        int randomIndex = left + (int)(Math.random() * (right - left));
        int temp = nums[randomIndex];
        nums[randomIndex] = nums[left];
        nums[left] = temp;
    }

    // 找 left,mid,right 中间的数放到 left 下标的位置
    private static void middleFirst(int[] nums, int left, int right) {
        if (right - left < 2) { // 小于3个元素
            return;
        }
        int mid = (left + right) / 2;
        int min = Math.min(nums[left], Math.min(nums[mid], nums[right]));
        int max = Math.max(nums[left], Math.max(nums[mid], nums[right]));
        if (nums[left] != max && nums[left] != min) {
            // nums[left] 就是中间元素
            return;
        }
        int midIndex; // 中间值的下标
        if (nums[left] == min) {
            midIndex = nums[mid] < nums[right] ? mid : right;
        } else { // nums[left]==max
            midIndex = nums[mid] > nums[right] ? mid : right;
        }
        int temp = nums[midIndex];
        nums[midIndex] = nums[left];
        nums[left] = temp;
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

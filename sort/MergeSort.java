package sort;

import java.util.Arrays;

/**
 * 归并排序，O(nlogn)，稳定
 * @author masikkk.com 2020-04-24 20:03
 */
public class MergeSort {
    public static int[] sort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] {nums[start]};
        }
        int mid = start + (end - start) / 2;
        int[] leftNums = mergeSort(nums, start, mid);
        int[] rightNums = mergeSort(nums, mid + 1, end);
        int[] merge = new int[end - start + 1];
        int i = 0, j = 0, k = 0;
        while (i < leftNums.length && j < rightNums.length) {
            // 注意，这里必须是小于等于，如果写成小于，则归并排序就是不稳定的了
            if (leftNums[i] <= rightNums[j]) {
                merge[k++] = leftNums[i++];
            } else {
                merge[k++] = rightNums[j++];
            }
        }
        while (i < leftNums.length) {
            merge[k++] = leftNums[i++];
        }
        while (j < rightNums.length) {
            merge[k++] = rightNums[j++];
        }
        return merge;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(MergeSort.sort(new int[] {4, 13, 2, 8, 1, 5, 1})));
        System.out.println(Arrays.toString(MergeSort.sort(new int[] {5,2,3,1})));
        System.out.println(Arrays.toString(MergeSort.sort(new int[] {5,1,1,2,0,0})));
        System.out.println(Arrays.toString(MergeSort.sort(new int[] {5,1})));
        System.out.println(Arrays.toString(MergeSort.sort(new int[] {1,5})));
        System.out.println(Arrays.toString(MergeSort.sort(new int[] {1,2,3,4,5})));
    }
}
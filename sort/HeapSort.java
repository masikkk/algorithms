package sort;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * 堆排序 O(nlogn) 不稳定
 * @author masikkk.com 2020-06-29 14:09
 */
public class HeapSort {
    public static int[] sort(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }
        // 构造最大堆
        for (int i = nums.length / 2; i >= 0; i--) {
            // 从最后一个非叶子结点 nums.length / 2 开始到根节点依次进行向下调整，调整完则构建成一个最大堆。
            adjustHeap(nums, i, nums.length - 1);
        }
        return nums;
    }

    // 从 start 开始向下调整最大堆 到 end 结束
    private static void adjustHeap(int[] nums, int start, int end) {
        int left = start * 2 + 1; // 左孩子
        int right = start * 2 + 2; // 右孩子
        int maxIndex = left <= end && nums[left] > nums[start] ? left : start; // start, left, right 中最大值的下标
        maxIndex = right <= end && nums[right] > nums[start] ? right : maxIndex;
        if (maxIndex != start) {
            swap(nums, maxIndex, start);
            adjustHeap(nums, maxIndex, end);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    @Test
    public void testHeapSort() {
        System.out.println(Arrays.toString(HeapSort.sort(new int[] {4, 13, 2, 8, 1, 5, 1})));
    }
}
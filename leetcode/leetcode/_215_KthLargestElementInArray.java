package leetcode.leetcode;

import structs.ListNode;

/**
 * 寻找数组中第K大的数
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author masikkk.com
 * @create 2020-02-20 16:27
 */
public class _215_KthLargestElementInArray {
    private static class SolutionV2020 {
        public int findKthLargest(int[] nums, int k) {
            int low = 0, high = nums.length -1;
            // 第k大的数在升序排序后数组中的下标
            int targetIndex = nums.length - k;
            int partition = partition(nums, low, high);
            while (partition != targetIndex) {
                if (partition < targetIndex) {
                    low = partition + 1;
                } else {
                    high = partition - 1;
                }
                partition = partition(nums, low, high);
            }
            return nums[partition];
        }

        // 一次快速排序partition，把nums中小于 nums[0] 的放左边，大于 nums[0] 的放右边
        private int partition(int[] nums, int low, int high) {
            if (null == nums || nums.length ==0) {
                return 0;
            }
            if (low == high) {
                return low;
            }
            // 选 nums[0] 当枢轴
            int pivot = nums[low];
            while (low < high) {
                while (low < high && nums[high] >= pivot) {
                   high--;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] <= pivot) {
                    low++;
                }
                nums[high] = nums[low];
            }
            // 枢轴归位
            nums[low] = pivot;
            return low;
        }
    }

    public static void main(String args[]) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findKthLargest(ListNode.stringToIntegerArray("[3,2,1,5,6,4]"), 2));
        System.out.println(solutionV2020.findKthLargest(ListNode.stringToIntegerArray("[3,2,3,1,2,4,5,5,6]"), 4));
    }
}

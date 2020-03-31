package leetcode.leetcode;

import java.util.Arrays;
import structs.ListNode;

/**
 * 排序数组
 * https://leetcode-cn.com/problems/sort-an-array/
 * @author masikkk.com
 * @create 2020-03-31 12:38
 */
public class _912_SortAnArray {
    private static class SolutionV2020 {
        public int[] sortArray(int[] nums) {
            if (null == nums || nums.length < 2) {
                return nums;
            }
            qsort(nums, 0, nums.length - 1);
            return nums;
        }

        private void qsort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int location = partition(nums, left, right);
            qsort(nums, left, location - 1);
            qsort(nums, location + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            // 从nums[left,...,right]中随机找一个数放到 left 下标的位置
//            randomFirst(nums, left, right);
            // 找 left,mid,right 中间的数放到 left 下标的位置
            middleFirst(nums, left, right);
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

        // 从nums[left,...,right]中随机找一个数放到 left 下标的位置
        private void randomFirst(int[] nums, int left, int right) {
            int randomIndex = left + (int)(Math.random() * (right - left));
            int temp = nums[randomIndex];
            nums[randomIndex] = nums[left];
            nums[left] = temp;
        }

        // 找 left,mid,right 中间的数放到 left 下标的位置
        private void middleFirst(int[] nums, int left, int right) {
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
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(solutionV2020.sortArray(ListNode.stringToIntegerArray("[5,2,3,1]"))));
        System.out.println(Arrays.toString(solutionV2020.sortArray(ListNode.stringToIntegerArray("[5,1,1,2,0,0]"))));
        System.out.println(Arrays.toString(solutionV2020.sortArray(ListNode.stringToIntegerArray("[5,1]"))));
        System.out.println(Arrays.toString(solutionV2020.sortArray(ListNode.stringToIntegerArray("[1,5]"))));
        System.out.println(Arrays.toString(solutionV2020.sortArray(ListNode.stringToIntegerArray("[1,2,3,4,5]"))));
    }
}

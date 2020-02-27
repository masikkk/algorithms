package problems;

import java.util.Arrays;
import structs.ListNode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author masikkk.com
 * @create 2020-02-27 10:56
 */
public class _034_FindFirstAndLastPositionOfElementInSortedArray {
    private static class SolutionV2020 {
        public int[] searchRange(int[] nums, int target) {
            int left = -1, right = -1;
            if (null == nums || 0 == nums.length) {
                return new int[]{left, right};
            }
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    left = mid;
                    while (left-1 >=0 && nums[left-1] == target) {
                        left--;
                    }
                    right = mid;
                    while (right+1 < nums.length && nums[right+1] == target) {
                        right++;
                    }
                    break;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return new int[] {left, right};
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(solutionV2020.searchRange(ListNode.stringToIntegerArray("[5,7,7,8,8,10]"), 8)));
        System.out.println(Arrays.toString(solutionV2020.searchRange(ListNode.stringToIntegerArray("[5,7,7,8,8,10]"), 6)));
        System.out.println(Arrays.toString(solutionV2020.searchRange(ListNode.stringToIntegerArray("[5,7,7,8,8,10]"), 5)));
        System.out.println(Arrays.toString(solutionV2020.searchRange(ListNode.stringToIntegerArray("[1]"), 1)));
        System.out.println(Arrays.toString(solutionV2020.searchRange(ListNode.stringToIntegerArray("[1,1]"), 1)));
        System.out.println(Arrays.toString(solutionV2020.searchRange(ListNode.stringToIntegerArray("[1,1]"), 2)));
    }
}

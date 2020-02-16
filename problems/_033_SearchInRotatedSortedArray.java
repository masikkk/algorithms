package problems;

import structs.ListNode;

/**
 * 在旋转有序数组中搜索
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class _033_SearchInRotatedSortedArray {
    private static class SolutionV2018 {
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[low]) {//左边有序，转折点在右边
                    if (target >= nums[low] && target < nums[mid]) {//target在左边
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {//右边有序，转折点在左边
                    if (target > nums[mid] && target <= nums[high]) {//target在右边
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    private static class SolutionV2020 {
        public int search(int[] nums, int target) {
            if (null == nums || nums.length == 0) {
                return -1;
            }
            int low = 0, high = nums.length -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (mid - 1 >= low && nums[low] <= nums[mid - 1]) {
                    // 左边是有序数组
                    if (target >= nums[low] && target <= nums[mid - 1]) {
                        high = mid -1;
                    } else {
                        low = mid +1;
                    }
                } else {
                    // 右边是有序数组
                    if (mid + 1 <= high && target >= nums[mid + 1] && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println("SolutionV2018:");
        System.out.println(solutionV2018.search(ListNode.stringToIntegerArray("[3, 1]"), 1));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println("SolutionV2020:");
        System.out.println(solutionV2020.search(ListNode.stringToIntegerArray("[]"), 3));
        System.out.println(solutionV2020.search(ListNode.stringToIntegerArray("[3]"), 3));
        System.out.println(solutionV2020.search(ListNode.stringToIntegerArray("[3, 1]"), 1));
        System.out.println(solutionV2020.search(ListNode.stringToIntegerArray("[3, 1, 2]"), 2));
        System.out.println(solutionV2020.search(ListNode.stringToIntegerArray("[4,5,6,7,0,1,2]"), 0));
        System.out.println(solutionV2020.search(ListNode.stringToIntegerArray("[4,5,6,7,0,1,2]"), 3));
        System.out.println(solutionV2020.search(ListNode.stringToIntegerArray("[6,7,1,2,3,4,5]"), 6));
        System.out.println(solutionV2020.search(ListNode.stringToIntegerArray("[3,4,5,6,7,8,1,2]"), 2));
    }
}

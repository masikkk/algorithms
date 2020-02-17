package problems;

import structs.ListNode;

/**
 * 旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class _153_FindMinimumInRotatedSortedArray {
    private static class SolutionV2018 {
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                //先判断nums[low,...,high]是否升序，即无旋转
                if (nums[low] <= nums[high]) {
                    return nums[low];
                }
                //nums[low,...,high]不是升序
                int mid = (low + high) / 2;
                if (nums[mid] >= nums[low]) {//左边升序，转折点在右边，最小值也在右边
                    low = mid + 1;
                } else {//右边升序，转折点在左边，最小值也在左边
                    high = mid;
                }
            }
            return nums[low];
        }
    }

    private static class SolutionV2020 {
        public int findMin(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                if (low == high) {
                    return nums[low];
                }
                if (high == low + 1) {
                    return Math.min(nums[low], nums[high]);
                }
                int mid = (low + high) / 2;
                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                }
                if (nums[low] <= nums[mid] && nums[mid] <= nums[high]) {
                    // 左右都有序
                    return nums[low];
                } else if (nums[low] <= nums[mid]) {
                    // 左边是有序的，最小值肯定再右边
                    low = mid + 1;
                } else {
                    // 右边是有序的，最小值肯定在左边
                    high = mid - 1;
                }
            }
            return nums[low];
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.findMin(ListNode.stringToIntegerArray("[3, 1, 2]")));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findMin(ListNode.stringToIntegerArray("[1]")));
        System.out.println(solutionV2020.findMin(ListNode.stringToIntegerArray("[7, 8]")));
        System.out.println(solutionV2020.findMin(ListNode.stringToIntegerArray("[8, 7]")));
        System.out.println(solutionV2020.findMin(ListNode.stringToIntegerArray("[5, 6, 4]")));
        System.out.println(solutionV2020.findMin(ListNode.stringToIntegerArray("[6, 4, 5]")));
        System.out.println(solutionV2020.findMin(ListNode.stringToIntegerArray("[4,5,6,7,0,1,2]")));
    }
}

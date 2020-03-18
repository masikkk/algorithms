package leetcode.leetcode;

import java.util.Arrays;
import structs.ListNode;

/**
 * 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * @author masikkk.com
 * @create 2020-02-17 22:07
 */
public class _189_RotateArray {
    private static class SolutionV2020 {
        public void rotate(int[] nums, int k) {
            if (null == nums || nums.length == 0 || (k % nums.length) == 0) {
                return;
            }
            // k 先对长度求余，防止溢出
            k = k % nums.length;
            reverse(nums, nums.length - k, nums.length - 1);
            reverse(nums, 0, nums.length - k - 1);
            reverse(nums, 0, nums.length - 1);
        }

        private void reverse(int[] nums, int left, int right) {
            if (null == nums || left == right) {
                return;
            }
            for (; left < right; left++, right--) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[] nums = ListNode.stringToIntegerArray("[1,2,3,4,5,6,7]");
        solutionV2020.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = ListNode.stringToIntegerArray("[-1,-100,3,99]");
        solutionV2020.rotate(nums2, 0);
        System.out.println(Arrays.toString(nums2));
    }
}

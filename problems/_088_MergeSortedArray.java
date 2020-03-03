package problems;

import java.util.Arrays;
import structs.ListNode;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author masikkk.com
 * @create 2020-03-03 13:38
 */
public class _088_MergeSortedArray {
    private static class SolutionV2020 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (null == nums1 || null == nums2 || 0 == n) {
                return;
            }
            // 从后往前的指针
            int right = m + n - 1;
            int i =  m - 1, j = n - 1;
            // 注意 nums1 的长度 m 可能为0
            while (right >= 0 && j >= 0) {
                if (i >= 0 && nums1[i] > nums2[j]) {
                    nums1[right--] = nums1[i--];
                } else {
                    nums1[right--] = nums2[j--];
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[] nums1 = ListNode.stringToIntegerArray("[1,2,3,0,0,0]");
        solutionV2020.merge(nums1, 3, ListNode.stringToIntegerArray("[2,5,6]"), 3);
        System.out.println(Arrays.toString(nums1));

        // 易错用例，数组 nums1 中没有值
        int[] nums2 = ListNode.stringToIntegerArray("[0]");
        solutionV2020.merge(nums2, 0, ListNode.stringToIntegerArray("[1]"), 1);
        System.out.println(Arrays.toString(nums2));
    }
}

package leetcode.leetcode;

/**
 * 两个有序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class _004_MedianOfTwoSortedArrays {
    private static class SolutionV2018 {
        //归并排序法
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length + nums2.length];
            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    res[k++] = nums1[i++];
                } else {
                    res[k++] = nums2[j++];
                }
            }
            while (i < nums1.length) {
                res[k++] = nums1[i++];
            }
            while (j < nums2.length) {
                res[k++] = nums2[j++];
            }
            return res.length % 2 == 0 ? (double) (res[res.length / 2] + res[(res.length / 2) - 1]) / 2 : res[res.length / 2];
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
    }
}

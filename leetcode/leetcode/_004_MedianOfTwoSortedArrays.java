package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 两个有序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class _004_MedianOfTwoSortedArrays {
    // 归并排序法
    private static class SolutionV2018 {
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

    @Test
    public void testSolutionV2018() {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
    }

    // 中位数一定是两个数组的从前往后数第 (m+n)/2 个元素
    private static class SolutionV202005Count {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 若 m+n 是奇数，中位数是单个数，即第 (m+n)/2 + 1 个元素
            // 若 m+n 是偶数，中位数是两个数，即第 (m+n)/2 和 第 (m+n)/2 + 1 个元素
            int medianCount = (nums1.length + nums2.length)/2 +1;
            // preMedian 是第 (m+n)/2 个元素，即当 m+n 是偶数时的第一个中位数
            int preMedian = 0, median = 0;
            int i = 0, j = 0;
            int count = 0; // 遍历的元素个数
            while (i < nums1.length || j < nums2.length) {
                if (i < nums1.length && j < nums2.length) {
                    median = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
                } else {
                    median = (i == nums1.length) ? nums2[j++] : nums1[i++];
                }
                count++;
                if (count == medianCount) {
                    break;
                }
                preMedian = median;
            }
            return (nums1.length + nums2.length) % 2 == 1 ? median : (double)(preMedian + median) / 2;
        }
    }

    @Test
    public void testSolutionV202005Count() {
        SolutionV202005Count solutionV202005Count = new SolutionV202005Count();
        System.out.println(solutionV202005Count.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(solutionV202005Count.findMedianSortedArrays(new int[] {1, 3}, new int[] {2,4}));
        System.out.println(solutionV202005Count.findMedianSortedArrays(new int[] {1, 2}, new int[] {3,4}));
    }

    public static class SolutionV202005Binary {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        }
    }
}

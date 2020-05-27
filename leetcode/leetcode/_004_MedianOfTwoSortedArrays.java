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

    // 转化为求两个有序数组的第k小元素，二分搜索法解决
    private static class SolutionV202005BinarySearch {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 两个有序数组的中位数即第 k 小的数(m+n 是偶数时需要求第 k-1 小和第 k 小的数)
            int k = (nums1.length + nums2.length) / 2 + 1;
            if ((nums1.length + nums2.length) % 2 == 1) {
                return getKthLeastElement(nums1, nums2, 0, 0, k);
            } else {
                int preKthLeast = getKthLeastElement(nums1, nums2, 0, 0, k - 1); // 第 k-1 小的元素
                int kthLeast = getKthLeastElement(nums1, nums2, 0, 0, k); // 第 k 小的元素
                return (preKthLeast + kthLeast) / 2.0;
            }
        }

        // 返回升序数组 nums1[nums1Start:] 和 nums2[nums2Start:] 中第 k 小的元素
        public int getKthLeastElement(int [] nums1, int [] nums2, int nums1Start, int nums2Start, int k) {
            // nums1 和 nums2 其中之一已结束，直接返回另一个数组的第 k 个元素
            if (nums1Start >= nums1.length || nums2Start >= nums2.length) {
                return nums1Start >= nums1.length ? nums2[nums2Start + k - 1] : nums1[nums1Start + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[nums1Start], nums2[nums2Start]);
            }
            int mid = k / 2;
            int nums1Value = nums1Start + mid - 1 < nums1.length ? nums1[nums1Start + mid - 1] : nums1[nums1.length - 1];
            int nums2Value = nums2Start + mid - 1 < nums2.length ? nums2[nums2Start + mid - 1] : nums2[nums2.length - 1];
            if (nums1Value <= nums2Value) {
                // 排除的元素个数
                int excludeCount = nums1Start + mid - 1 < nums1.length ? mid : nums1.length - nums1Start;
                // 从剩余子数组中找第 k - excludeCount 小的元素
                return getKthLeastElement(nums1, nums2, nums1Start + mid, nums2Start, k - excludeCount);
            } else {
                // 排除的元素个数
                int excludeCount = nums2Start + mid - 1 < nums2.length ? mid : nums2.length - nums2Start;
                // 从剩余子数组中找第 k - excludeCount 小的元素
                return getKthLeastElement(nums1, nums2, nums1Start, nums2Start + mid, k - excludeCount);
            }
        }
    }

    @Test
    public void testSolutionV202005BinarySearch() {
        SolutionV202005BinarySearch solutionV202005BinarySearch = new SolutionV202005BinarySearch();
        System.out.println(solutionV202005BinarySearch.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(solutionV202005BinarySearch.findMedianSortedArrays(new int[] {1, 3}, new int[] {2,4}));
        System.out.println(solutionV202005BinarySearch.findMedianSortedArrays(new int[] {1, 2}, new int[] {3,4}));
        System.out.println(solutionV202005BinarySearch.findMedianSortedArrays(new int[] {1}, new int[] {2,3,4,5,6}));
    }
}

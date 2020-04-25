package leetcode.offer;

import org.junit.jupiter.api.Test;

/**
 * 《剑指offer》面试题51. 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @author masikkk.com 2020-04-24 16:16
 */
public class _051_ReversePairInArray {
    // 暴力，超时，35 / 139 个通过测试用例
    private static class SolutionV2020Brutal {
        public int reversePairs(int[] nums) {
            if (null == nums || nums.length == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        count ++;
                    }
                }
            }
            return count;
        }
    }

    @Test
    public void testSolutionV2020Brutal() {
        SolutionV2020Brutal solutionV2020Brutal = new SolutionV2020Brutal();
        System.out.println(solutionV2020Brutal.reversePairs(new int[] {7,5,6,4}));
    }

    // 基于归并排序的逆序对统计
    private static class SolutionV2020MergeSort {
        int count = 0;
        public int reversePairs(int[] nums) {
            if (null == nums || nums.length < 2) {
                return 0;
            }
            count = 0;
            int[] res = mergeSort(nums, 0, nums.length - 1);
//            System.out.println(Arrays.toString(res));
            return count;
        }

        public int[] mergeSort(int[] nums, int start, int end) {
            if (start == end) {
                return new int[] {nums[start]};
            }
            int mid = (start + end) / 2;
            int[] leftNums = mergeSort(nums, start, mid);
            int[] rightNums = mergeSort(nums, mid + 1, end);
            int[] res = new int[end - start + 1];
            int i = 0, j = 0, k = 0;
            while (i < leftNums.length && j < rightNums.length) {
                if (leftNums[i] <= rightNums[j]) {
                    res[k++] = leftNums[i++];
                    count += j;
                } else {
                    res[k++] = rightNums[j++];
                }
            }
            while (i < leftNums.length) {
                res[k++] = leftNums[i++];
                count += j;
            }
            while (j < rightNums.length) {
                res[k++] = rightNums[j++];
            }
            return res;
        }
    }

    @Test
    public void testSolutionV2020MergeSort() {
        SolutionV2020MergeSort solutionV2020MergeSort = new SolutionV2020MergeSort();
        System.out.println(solutionV2020MergeSort.reversePairs(new int[] {7,5,6,4}));
    }
}
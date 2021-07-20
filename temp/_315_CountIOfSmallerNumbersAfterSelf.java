package temp;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 计算右侧小于当前元素的个数
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * @author masikkk.com
 * @create: 2020-07-11 21:54
 */
public class _315_CountIOfSmallerNumbersAfterSelf {
    private static class SolutionV202007 {
        public List<Integer> countSmaller(int[] nums) {
            if (null == nums || nums.length < 1) {
                return Collections.emptyList();
            }
            int[] res = new int[nums.length]; // 最后一个元素默认为 0
            int[] sortedArray = new int[nums.length];
            sortedArray[0] = nums[nums.length - 1];
            int end = 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                // 在有序数组 sortedArray 中二分搜索 nums[i] 的插入位置，返回值就是右侧比 nums[i] 小的元素个数
                int insertIndex = binarySearch(sortedArray, end, nums[i]);
                res[i] = insertIndex;
                // 插入有序数组
                insert(sortedArray, end++, insertIndex, nums[i]);
            }
            return Arrays.stream(res).boxed().collect(Collectors.toList());
        }

        // 在有序数组 sortedArray[0..end] 的下标 insertIndex 处插入元素 num，移动后续元素
        private void insert(int[] sortedArray, int end, int insertIndex, int num) {
            for (int i = end; i >= insertIndex; i--) {
                sortedArray[i + 1] = sortedArray[i];
            }
            sortedArray[insertIndex] = num;
        }

        // 二分搜索 target 在有序数组 sortedArray[0..end] 中第一次出现或应该插入的位置下标，有重复元素时返回 target 第一次出现或应插入的位置下标
        private int binarySearch(int[] sortedArray, int end, int target) {
            int left = 0, right = end;
            while (left <= right) {
                if (left == right) { // 特殊处理 left==right 的情况
                    return target > sortedArray[left] ? left + 1 : left;
                }
                int mid = left + (right - left) / 2;
                if (sortedArray[mid] == target) { // 相等时要继续在包含 mid 的左侧搜索
                    right = mid;
                } else if (sortedArray[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    @Test
    public void testBinarySearch() {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        // 测试 binarySearch 方法
        System.out.println(solutionV202007.binarySearch(new int[]{1}, 0,  0));
        System.out.println(solutionV202007.binarySearch(new int[]{1}, 0, 1));
        System.out.println(solutionV202007.binarySearch(new int[]{1}, 0, 2));
        System.out.println(solutionV202007.binarySearch(new int[] {1,3}, 1, 0));
        System.out.println(solutionV202007.binarySearch(new int[] {1,3}, 1, 1));
        System.out.println(solutionV202007.binarySearch(new int[] {1,3}, 1, 2));
        System.out.println(solutionV202007.binarySearch(new int[] {1,3}, 1, 3));
        System.out.println(solutionV202007.binarySearch(new int[] {1,3}, 1, 4));
    }

    @Test
    public void testSolutionV202007() {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.countSmaller(new int[] {5,2,6,1}));
        System.out.println(solutionV202007.countSmaller(new int[] {5}));
    }
}

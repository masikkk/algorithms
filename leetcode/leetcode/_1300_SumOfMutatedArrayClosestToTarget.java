package leetcode.leetcode;

import java.util.Arrays;

/**
 * 转变数组后最接近目标值的数组和
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 * @author masikkk.com 2020-06-14 20:41
 */
public class _1300_SumOfMutatedArrayClosestToTarget {
    private static class SolutionV202006 {
        public int findBestValue(int[] arr, int target) {
            // 升序排序
            Arrays.sort(arr);
            // 数组 arr 的前缀和， preSum[i] 表示下标 i 之前所有元素的和
            int[] preSum = new int[arr.length + 1];
            for (int i = 1; i <= arr.length; i++) {
                preSum[i] = preSum[i - 1] + arr[i - 1];
            }
            // valueLower 使数组转化后最接近 target 且小于等于 target 的值
            int valueLower = -1;
            int low = 0, high = arr[arr.length - 1];
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int midSum = mutatedSum(arr, preSum, mid);
                int midPlus1Sum = mutatedSum(arr, preSum, mid + 1);
                if (midSum == target || midPlus1Sum == target) {
                    return midSum == target ? mid : mid + 1;
                }
                if (midSum < target && midPlus1Sum > target) {
                    valueLower = mid;
                    break;
                }
                if (midSum < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (low > high) {
                // low 大于 high 表示数组无需改变任何值的和就最接近 target
                return high;
            }
            int valueLowerSum = mutatedSum(arr, preSum, valueLower); // 最接近 target 且小于 target 的和
            int valueUpperSum = mutatedSum(arr, preSum, valueLower + 1); // 最接近 target 且大于 target 的和
            return Math.abs(valueUpperSum - target) < Math.abs(valueLowerSum - target) ? valueLower + 1 : valueLower;
        }

        // 返回把升序数组 arr 中所有大于 x 的值都变为 x 后的元素和， preSum 是数组 arr 的前缀和
        private int mutatedSum(int[] arr, int[] preSum, int x) {
            int xIndex = binarySearch(arr, x);
            return preSum[xIndex] + x * (arr.length - xIndex);
        }

        // 在升序数组 arr 中查找 x 第一次出现的位置下标，若 x 不存在返回应该插入的位置。注意 arr 中可能有重复元素
        private int binarySearch(int[] arr, int x) {
            int res = -1;
            int low = 0, high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == x) {
                    res = mid;
                    break;
                } else if (arr[mid] > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (res == -1) {
                // 没找到 x
                return high + 1;
            } else {
                while (res > 0 && arr[res - 1] == arr[res]) {
                    res--;
                }
                return res;
            }
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.findBestValue(new int[] {4,9,3}, 10));
        System.out.println(solutionV202006.findBestValue(new int[] {2,3,5}, 10));
        System.out.println(solutionV202006.findBestValue(new int[] {60864,25176,27249,21296,20204}, 56803));
        System.out.println(solutionV202006.findBestValue(new int[] {2,3,5}, 11));
        System.out.println(solutionV202006.findBestValue(new int[] {2,2,2}, 3));
    }
}
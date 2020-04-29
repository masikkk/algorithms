package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 山脉数组中查找目标值
 * https://leetcode-cn.com/problems/find-in-mountain-array/
 * @author masikkk.com 2020-04-29 13:48
 */
public class _1095_FindInMountainArray {
    // 山脉数组接口
    interface MountainArray {
        public int get(int index);
        public int length();
    }

    // 山脉数组实现类
    class MyMountainArray implements MountainArray {
        private int[] array;

        MyMountainArray(int[] arr) {
            this.array = arr;
        }

        @Override
        public int get(int index) {
            return array[index];
        }

        @Override
        public int length() {
            return array.length;
        }
    }

    private static class SolutionV2020 {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            // 找峰值下标
            int peekIndex = findPeek(mountainArr);
            if (mountainArr.get(peekIndex) == target) {
                return peekIndex;
            }
            // 在峰值左侧升序序列中二分搜索
            if (peekIndex - 1 >= 0) {
                int leftRes = binarySearch(mountainArr, 0, peekIndex - 1, target, true);
                if (leftRes != -1) {
                    return leftRes;
                }
            }
            // 在峰值右侧降序序列中二分搜索
            int length = mountainArr.length();
            if (peekIndex + 1 < length) {
                int rightRes = binarySearch(mountainArr, peekIndex + 1, length -1, target, false);
                return rightRes;
            }
            return -1;
        }

        // 二分搜索找山峰数组中峰值的下标
        private int findPeek(MountainArray mountainArr) {
            int length = mountainArr.length();
            int left = 0, right = length -1 ;
            while (left <= right) {
                if (right - left < 2) {
                    return mountainArr.get(left) > mountainArr.get(right) ? left : right;
                }
                int mid = left + (right - left) / 2;
                int midValue = mountainArr.get(mid), midLeftValue = mountainArr.get(mid - 1), midRightValue = mountainArr.get(mid + 1);
                if (midValue > midLeftValue && midValue > midRightValue) {
                    return mid;
                } else if (midValue > midLeftValue && midValue < midRightValue) {
                    // mid在左升序序列中，则峰值在右侧
                    left = mid + 1;
                } else {
                    // mid在右降序序列中，则峰值在左侧
                    right = mid - 1;
                }
            }
            return 0;
        }

        /**
         * 在有序数组 mountainArray[start...end] 中二分查找 target，找不到返回-1
         * @param mountainArray
         * @param start
         * @param end
         * @param target
         * @param asc true: 升序，false 降序
         * @return
         */
        private int binarySearch(MountainArray mountainArray, int start, int end, int target, boolean asc) {
            int left = start, right = end;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midValue = mountainArray.get(mid);
                if (midValue == target) {
                    return mid;
                } else if (midValue < target) {
                    if (asc) {
                        left = mid + 1;
                    } else {
                        right = mid -1;
                    }
                } else {
                    if (asc) {
                        right = mid -1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }

    @Test
    public void testSolutionV2020() {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findInMountainArray(3, new MyMountainArray(new int[] {1,2,3,4,5,3,1})));
        System.out.println(solutionV2020.findInMountainArray(3, new MyMountainArray(new int[] {0,1,2,4,2,1})));
        System.out.println(solutionV2020.findInMountainArray(1, new MyMountainArray(new int[] {1,2,3})));
        System.out.println(solutionV2020.findInMountainArray(1, new MyMountainArray(new int[] {1,2,3,1})));
        System.out.println(solutionV2020.findInMountainArray(1, new MyMountainArray(new int[] {3,2,1})));
        System.out.println(solutionV2020.findInMountainArray(0, new MyMountainArray(new int[] {3,5,3,2,0})));
    }
}
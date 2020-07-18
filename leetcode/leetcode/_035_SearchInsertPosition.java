package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @author masikkk.com
 * @create: 2008-02-25 21:11
 */
public class _035_SearchInsertPosition {
    private static class SolutionV2018 {
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return high + 1;//最后high+1肯定等于low
        }
    }

    @Test
    public void testSolutionV2018() {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.searchInsert(new int[]{1}, 1));
    }

    private static class SolutionV202007 {
        public int searchInsert(int[] nums, int target) {
            if (null == nums || nums.length < 1) {
                return 0;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    @Test
    public void testSolutionV202007() {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.searchInsert(new int[]{1}, 0));
        System.out.println(solutionV202007.searchInsert(new int[]{1}, 1));
        System.out.println(solutionV202007.searchInsert(new int[]{1}, 2));
    }
}

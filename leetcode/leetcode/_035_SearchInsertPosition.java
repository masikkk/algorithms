package leetcode.leetcode;

/**
 * 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
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

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.searchInsert(new int[]{1}, 1));
    }
}

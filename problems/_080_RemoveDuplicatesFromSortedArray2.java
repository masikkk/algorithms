package problems;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项2
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author masikkk.com
 * @create 2020-02-19 13:44
 */
public class _080_RemoveDuplicatesFromSortedArray2 {
    private static class SolutionV2020 {
        public int removeDuplicates(int[] nums) {
            if (null == nums) {
                return 0;
            }
            if (nums.length < 3) {
                return nums.length;
            }
            int left = 0, count = 0;
            for (int right = 1; right < nums.length;) {
                if (nums[right] == nums[right - 1]) {
                    // 和前一个数相同
                    if (count == 0) {
                        // 第二个重复的，不算重复
                        nums[++left] = nums[right++];
                        count++;
                    } else {
                        count++;
                        right++;
                    }
                } else {
                    // 和前一个数不同，count清零
                    count = 0;
                    nums[++left] = nums[right++];
                }
            }
            return left + 1;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(solutionV2020.removeDuplicates(nums) + ": " + Arrays.toString(nums));
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        System.out.println(solutionV2020.removeDuplicates(nums2) + ": " + Arrays.toString(nums2));
    }
}

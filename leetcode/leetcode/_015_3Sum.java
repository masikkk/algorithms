package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import structs.ArrayUtils;

/**
 * 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @author masikkk.com 2020-06-12 19:45
 */
public class _015_3Sum {
    private static class SolutionV202006 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            // 升序排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue; // 跳过重复元素
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < nums.length && left < right) {
                    if (left > i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue; // 跳过重复元素
                    }
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] < 0) {
                        // 三数之和比 0 小，左边界 left 增加
                        left++;
                    } else {
                        // 三数之和比 0 大，右边界 right 减小
                        right--;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        ArrayUtils.printListList(solutionV202006.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        ArrayUtils.printListList(solutionV202006.threeSum(new int[] {0, 0, 0, 0, 0}));
    }
}
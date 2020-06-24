package leetcode.leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author masikkk.com 2020-06-24 18:42
 */
public class _016_3SumClosest {
    private static class SolutionV202006 {
        public int threeSumClosest(int[] nums, int target) {
            // 升序排序
            Arrays.sort(nums);
            // 最接近的值
            int closest = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < nums.length; i++) {
                // 固定 nums[i] 后的目标值
                int thisTarget = target - nums[i];
                // 固定 nums[i] 后双指针遍历数组
                for (int j = i + 1, k = nums.length - 1; j < k;) {
                    int twoSum = nums[j] + nums[k];
                    if (twoSum == thisTarget) {
                        return target;
                    }
                    if (twoSum < thisTarget) {
                        // 小于目标值，左边界右移增加两数之和
                        j++;
                    } else {
                        // 大于目标值，右边界左移减少两数之和
                        k--;
                    }
                    // 更新 closest
                    closest = Math.abs(thisTarget - twoSum) < Math.abs(target - closest) ? nums[i] + twoSum : closest;
                }
            }
            return closest;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }
}
package leetcode.leetcode;

import structs.ListNode;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author masikkk.com
 * @create 2020-04-04 19:38
 */
public class _042_TrappingRainWater {
    private static class SolutionV2020Brutal {
        public int trap(int[] height) {
            if (null == height || height.length < 3) {
                return 0;
            }
            int leftMax = height[0];
            int res = 0;
            for (int i = 1; i < height.length; i++) {
                if (height[i] >= leftMax) {
                    leftMax = height[i];
                    continue;
                }
                int rightMax = 0;
                for (int j = i+1; j < height.length; j++) {
                    rightMax = Math.max(rightMax, height[j]);
                    if (rightMax >= leftMax) {
                        break;
                    }
                }
                // 找到左右最大值，min(leftMax, rightMax) 和 当前值的差就是当前直方图能接住的雨水
                if (Math.min(leftMax, rightMax) > height[i]) {
                    res += Math.min(leftMax, rightMax) - height[i];
                }
                leftMax = Math.max(leftMax, height[i]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020Brutal solutionV2020Brutal = new SolutionV2020Brutal();
        System.out.println(solutionV2020Brutal.trap(ListNode.stringToIntegerArray("[0,1,0,2,1,0,1,3,2,1,2,1]")));
        System.out.println(solutionV2020Brutal.trap(ListNode.stringToIntegerArray("[1,0,1]")));
    }
}

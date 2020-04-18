package leetcode.leetcode;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author masikkk.com 2020-04-18 18:39
 */
public class _011_ContainerWithMostWater {
    private static class SolutionV2020 {
        public int maxArea(int[] height) {
            int max = 0;
            int left = 0, right = height.length - 1;
            while (left < right) {
                max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
                if (height[left] < height[right]) {
                    left++;
                } else if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                    right--;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
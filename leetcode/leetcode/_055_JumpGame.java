package leetcode.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * @author si.ma
 * @create 2020-04-08 16:50
 */
public class _055_JumpGame {
    private static class SolutionV2020 {
        Set<Integer> visited;
        public boolean canJump(int[] nums) {
            if (null == nums || nums.length < 2) {
                return true;
            }
            visited = new HashSet<>(nums.length);
            return dfs(nums, 0);
        }

        private boolean dfs(int[] nums, int start) {
            boolean res = false;
            for (int i = 1; i <= nums[start]; i++) {
                if (start + i >= nums.length - 1) {
                    return true;
                }
                if (!visited.contains(start + i)) {
                    boolean canJump = dfs(nums, start + i);
                    visited.add(start + i);
                    res |= canJump;
                }
            }
            return res;
        }

        public boolean canJumpQueue(int[] nums) {
            if (null == nums || nums.length < 2) {
                return true;
            }
            Set<Integer> visited = new HashSet<>(nums.length);
            // 队列 queue 存放下次可跳跃到的结点的下标，类似层次遍历
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited.add(current);
                // 从当前点可以跳到哪些点
                for (int i = 1; i <= nums[current]; i++) {
                    int next = current + i;
                    // 若能直接跳到末尾则结束
                    if (next >= nums.length - 1) {
                        return true;
                    }
                    if (!visited.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.canJumpQueue(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020.canJumpQueue(new int[] {3,2,1,0,4}));
        System.out.println(solutionV2020.canJumpQueue(
                new int[]{1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8,
                        6, 8, 3, 2, 8, 5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3,
                        2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0}));

        System.out.println(solutionV2020.canJump(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020.canJump(new int[] {3,2,1,0,4}));
        System.out.println(solutionV2020.canJump(
                new int[]{1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8,
                        6, 8, 3, 2, 8, 5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3,
                        2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0}));
    }
}

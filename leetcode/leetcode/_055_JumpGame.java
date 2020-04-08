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
        public boolean canJump(int[] nums) {
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
        System.out.println(solutionV2020.canJump(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020.canJump(new int[] {3,2,1,0,4}));
    }
}
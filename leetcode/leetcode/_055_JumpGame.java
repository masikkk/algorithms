package leetcode.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * @author masikkk.com
 * @create 2020-04-08 16:50
 */
public class _055_JumpGame {
    private static class SolutionV2020Greedy {
        public boolean canJump(int[] nums) {
            if (null == nums || nums.length < 2) {
                return true;
            }
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > max) {
                    return false;
                }
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void testSolutionV2020Greedy() {
        SolutionV2020Greedy solutionV2020Greedy = new SolutionV2020Greedy();
        System.out.println(solutionV2020Greedy.canJump(new int[] {2,5,0,0}));
        System.out.println(solutionV2020Greedy.canJump(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020Greedy.canJump(new int[] {3,2,1,0,4}));
        System.out.println(solutionV2020Greedy.canJump(
                new int[]{1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8,
                        6, 8, 3, 2, 8, 5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3,
                        2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0}));
    }

    // 带备忘录的DF，超时，能通过 74/75 个测试用例S
    private static class SolutionV2020DfsWithMemo {
        Set<Integer> good;
        Set<Integer> bad;
        public boolean canJump(int[] nums) {
            if (null == nums || nums.length < 2) {
                return true;
            }
            // good 可到达结尾的结点集, bad 不可到达结尾的结点集
            good = new HashSet<>();
            bad = new HashSet<>();
            return dfs(nums, 0);
        }

        // 深度优先搜索
        private boolean dfs(int[] nums, int start) {
            if (good.contains(start)) {
                return true;
            } else if (bad.contains(start)) {
                return false;
            }
            // 优化，i 从 nums[start] 往前 遍历，也就是从跳的最远的位置开始dfs
            for (int i = nums[start]; i >= 1; i--) {
                if (start + i >= nums.length - 1) {
                    good.add(start + i);
                    return true;
                }
                if (dfs(nums, start + i)) {
                    good.add(start + i);
                    return true;
                } else {
                    bad.add(start + i);
                }
            }
            return false;
        }
    }

    @Test
    public void testSolutionV2020DfsWithMemo() {
        SolutionV2020DfsWithMemo solutionV2020DfsWithMemo = new SolutionV2020DfsWithMemo();
        System.out.println(solutionV2020DfsWithMemo.canJump(new int[] {2,5,0,0}));
        System.out.println(solutionV2020DfsWithMemo.canJump(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020DfsWithMemo.canJump(new int[] {3,2,1,0,4}));
        System.out.println(solutionV2020DfsWithMemo.canJump(
                new int[]{1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8,
                        6, 8, 3, 2, 8, 5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3,
                        2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0}));
    }

    // 深度优先搜索（回溯），超时，能通过 74/75 个测试用例
    private static class SolutionV2020DFS {
        Set<Integer> visited;
        public boolean canJump(int[] nums) {
            if (null == nums || nums.length < 2) {
                return true;
            }
            // 已访问过的，无法跳到末尾的结点
            visited = new HashSet<>(nums.length);
            return dfs(nums, 0);
        }

        // 深度优先搜索
        private boolean dfs(int[] nums, int start) {
            if (visited.contains(start)) {
                return false;
            }
            // 优化，i 从 nums[start] 往前 遍历，也就是从跳的最远的位置开始dfs
            for (int i = nums[start]; i >= 1; i--) {
                if (start + i >= nums.length - 1) {
                    return true;
                }
                if (!visited.contains(start + i)) {
                    if(dfs(nums, start + i)) {
                        return true;
                    }
                    visited.add(start + i);
                }
            }
            return false;
        }
    }

    @Test
    public void testSolutionV2020DFS() {
        SolutionV2020DFS solutionV2020DFS = new SolutionV2020DFS();
        System.out.println(solutionV2020DFS.canJump(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020DFS.canJump(new int[] {3,2,1,0,4}));
        System.out.println(solutionV2020DFS.canJump(new int[] {2,5,0,0}));
        System.out.println(solutionV2020DFS.canJump(
                new int[]{1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8,
                        6, 8, 3, 2, 8, 5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3,
                        2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0}));
    }

    // 广度优先搜索，层次遍历，超时，能通过 70/75 个用例
    private static class SolutionV2020BFS {
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

    @Test
    public void testSolutionV2020BFS() {
        SolutionV2020BFS solutionV2020BFS = new SolutionV2020BFS();
        System.out.println(solutionV2020BFS.canJump(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020BFS.canJump(new int[] {3,2,1,0,4}));
        System.out.println(solutionV2020BFS.canJump(
                new int[]{1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8,
                        6, 8, 3, 2, 8, 5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3,
                        2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0}));
    }
}

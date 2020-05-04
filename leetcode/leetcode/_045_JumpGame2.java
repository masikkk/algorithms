package leetcode.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * 跳跃游戏2
 * https://leetcode-cn.com/problems/jump-game-ii/
 * @author masikkk.com 2020-05-04 15:05
 */
public class _045_JumpGame2 {
    private static class SolutionV2020Greedy {
        public int jump(int[] nums) {
            if (null == nums || nums.length < 2) {
                return 0;
            }
            int steps = 0;
            int nextEnd = 0; // 下一步能跳到的最远下标，只要在 nextEnd 范围内都可一步完成
            int farthest = 0; // 当前能跳到的最远下标
            for (int i = 0; i < nums.length; i++) {
                farthest = Math.max(farthest, i + nums[i]);
                // 可以跳到末尾，直接结束
                if (farthest >= nums.length - 1) {
                    return steps + 1;
                }
                // i大于等于上一步的最远距离时，更新下一步的最远距离为当前能跳到的最远距离，步数step加1
                if (i >= nextEnd) {
                    nextEnd = farthest;
                    steps++;
                }
            }
            return steps;
        }
    }

    @Test
    public void testSolutionV2020Greedy() {
        SolutionV2020Greedy solutionV2020Greedy = new SolutionV2020Greedy();
        System.out.println(solutionV2020Greedy.jump(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020Greedy.jump(new int[] {1,2}));
        System.out.println(solutionV2020Greedy.jump(new int[] {0}));
    }

    // 广度优先搜索，超时，84 / 92 个通过测试用例
    private static class SolutionV2020BFS {
        public int jump(int[] nums) {
            if (null == nums || nums.length < 2) {
                return 0;
            }
            // 标记已访问过的结点
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            // 跳跃的步数
            int steps = 1;
            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                for (int i = 0; i < levelCount; i++) {
                    Integer start = queue.poll();
                    visited.add(start);
                    for (int j = 1; j <= nums[start]; j++) {
                        int jumpTo = start + j;
                        if (jumpTo >= nums.length - 1) {
                            return steps;
                        }
                        if (!visited.contains(jumpTo)) {
                            queue.offer(jumpTo);
                        }
                    }
                }
                steps++;
            }
            return steps;
        }
    }

    @Test
    public void testSolutionV2020() {
        SolutionV2020BFS solutionV2020BFS = new SolutionV2020BFS();
        System.out.println(solutionV2020BFS.jump(new int[] {2,3,1,1,4}));
        System.out.println(solutionV2020BFS.jump(new int[] {0}));
    }
}
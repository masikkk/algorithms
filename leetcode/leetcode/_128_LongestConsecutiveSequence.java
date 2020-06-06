package leetcode.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @author masikkk.com 2020-06-06 20:51
 */
public class _128_LongestConsecutiveSequence {
    private static class SolutionV202006 {
        public int longestConsecutive(int[] nums) {
            if (null == nums || nums.length < 1) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i);
            }
            int maxLength = 0;
            for (int i : nums) {
                // 只遍历没有出现在其他连续序列中的元素， 即 i-1 不存在
                if (!set.contains(i - 1)) {
                    int length = 1;
                    int j = i;
                    while (set.contains(j + 1)) {
                        j++;
                        length++;
                    }
                    maxLength = Math.max(maxLength, length);
                }
            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }
}
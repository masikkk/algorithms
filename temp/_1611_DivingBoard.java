package temp;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 《程序员面试金典（第 6 版）》面试题 16.11. 跳水板
 * https://leetcode-cn.com/problems/diving-board-lcci/
 * @author masikkk.com
 * @create: 2020-07-08 23:08
 */
public class _1611_DivingBoard {
    // 回溯法，超时
    private static class SolutionV202007Backtrack {
        private Set<Integer> results;
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[]{};
            }
            if (shorter == longer) {
                return new int[] {shorter * k};
            }
            results = new TreeSet<>();
            backtrack(shorter, longer, 0, k);
            return results.stream().mapToInt(Integer::intValue).toArray();
        }

        public void backtrack(int shorter, int longer, int res, int left) {
            if (left == 0) {
                results.add(res);
                return;
            }
            // 选择 shorter
            backtrack(shorter, longer, res + shorter, left - 1);
            // 选择 longer
            backtrack(shorter, longer, res + longer, left - 1);
        }
    }

    public static void main(String[] args) {
        SolutionV202007Backtrack solutionV202007Backtrack = new SolutionV202007Backtrack();
        System.out.println(Arrays.toString(solutionV202007Backtrack.divingBoard(1,2,3)));
        // 易错用例
        System.out.println(Arrays.toString(solutionV202007Backtrack.divingBoard(1,1,0)));
        System.out.println(Arrays.toString(solutionV202007Backtrack.divingBoard(1,1,10000)));
    }
}

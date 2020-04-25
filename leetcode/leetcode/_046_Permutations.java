package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import structs.ArrayUtils;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 * @author masikkk.com 2020-04-25 20:32
 */
public class _046_Permutations {
    private static class SolutionV2020 {
        private List<List<Integer>> res;
        public List<List<Integer>> permute(int[] nums) {
            if (null == nums || 0 == nums.length) {
                return Collections.emptyList();
            }
            res = new ArrayList<>();
            Set<Integer> choices = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            backtrace(new LinkedList<>(), choices);
            return res;
        }

        // 回溯，permute 当前的排列， choices 当前可用的选择
        private void backtrace(List<Integer> permute, Set<Integer> choices) {
            if (choices.size() == 0) {
                res.add(new ArrayList<>(permute));
                return;
            }
            for (Integer choice : new HashSet<>(choices)) {
                permute.add(choice);
                choices.remove(choice);
                backtrace(permute, choices);
                permute.remove(choice);
                choices.add(choice);
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        ArrayUtils.printListList(solutionV2020.permute(new int[] {1,2,3}));
    }
}
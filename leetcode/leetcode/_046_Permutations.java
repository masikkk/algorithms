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

        /**
         * 回溯
         * @param permute 当前的排列，用 stack 存储方便在末尾 push(选择) 和 pop(撤销)， LinkedList 实现了 Deque 接口，可当做栈使用
         * @param choices 当前可用的选择 集合
         */
        private void backtrace(LinkedList<Integer> permute, Set<Integer> choices) {
            if (choices.size() == 0) {
                // 剩余可用选择为0，结束，加入结果集
                res.add(new ArrayList<>(permute));
                return;
            }
            // 遍历选择列表
            for (Integer choice : new HashSet<>(choices)) {
                permute.push(choice); // 选择 choice 加入排列
                choices.remove(choice); // 把 choice 从剩余可用选择集合中删除
                backtrace(permute, choices); // 递归进行后续选择
                permute.pop(); // 回退撤销 choice 选择
                choices.add(choice); // 把 choice 恢复到剩余可用选择集合
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        ArrayUtils.printListList(solutionV2020.permute(new int[] {1,2,3}));
    }
}
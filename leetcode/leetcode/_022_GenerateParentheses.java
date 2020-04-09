package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author si.ma
 * @create 2020-04-09 14:05
 */
public class _022_GenerateParentheses {
    private static class SolutionV2020 {
        Set<String> res; // 最终结果集
        int n;
        public List<String> generateParenthesis(int n) {
            this.n = n;
            this.res = new HashSet<>();
            // n为1时特例处理
            if (n == 1) {
                List<String> trivial = new ArrayList<>();
                trivial.add("()");
                return trivial;
            }
            // 用一个双端队列 deque 保存已选择的部分
            Deque<String> deque = new LinkedList<>();
            deque.offer("("); // 第一个元素一定是左括号
            // 回溯生成括号
            backtrack(deque, 1);
            return new ArrayList<>(res);
        }

        // 回溯生成括号，deque 是当前已选择的部分， leftCount 是已选择部分中左括号个数
        private void backtrack(Deque<String> deque, int leftCount) {
            if (deque.size() == n * 2) {
                res.add(deque.stream().collect(Collectors.joining()));
                return;
            }
            // 已经选择了 n 个左括号，则剩余一定全是右括号
            if (leftCount == n) {
                String newParent = deque.stream().collect(Collectors.joining());
                for (int i = deque.size(); i < n * 2; i++) {
                    newParent += ")";
                }
                res.add(newParent);
                return;
            }
            if (leftCount < n) {
                // 选择左括号
                deque.offer("(");
                backtrack(deque, leftCount + 1);
                // 回溯(撤回)
                deque.pollLast();

                // 当 deque 里左括号比右括号多时，可以放右括号
                if (leftCount > deque.size() - leftCount) {
                    // 选择右括号
                    deque.offer(")");
                    backtrack(deque, leftCount);
                    // 回溯
                    deque.pollLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.print(solutionV2020.generateParenthesis(3));
    }
}

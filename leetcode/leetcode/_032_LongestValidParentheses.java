package leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author masikkk.com
 * @create: 2020-07-04 17:05
 */
public class _032_LongestValidParentheses {
    private static class SolutionV202007 {
        public int longestValidParentheses(String s) {
            if (null == s || s.length() < 2) {
                return 0;
            }
            // 栈中存放的是数组下标
            Deque<Integer> stack = new LinkedList<>();
            stack.push(-1); // 栈顶是一个合法括号子串的前一个字符下标，初始为 -1
            int maxValidLength = 0; // 全局合法括号子串最大值
            for (int i = 0; i < s.length(); i++) {
                // 遇到左括号直接将下标入栈
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    // 遇到右括号时，栈顶要么是和当前右括号(即 s[i])匹配的左括号，要么是"一个合法括号子串的前一个字符下标"
                    stack.pop();
                    if (stack.isEmpty()) {
                        // 如果栈为空，说明当前合法子串结束，当前字符下标就是"一个合法括号子串的前一个字符下标"
                        stack.push(i);
                    } else {
                        // 栈不空，说明还在一个合法子串内，当前合法子串长度更新为"当前下标 减去 一个合法括号子串的前一个字符下标"，并更新全局最大值
                        maxValidLength = Math.max(maxValidLength, i - stack.peek());
                    }
                }
            }
            return maxValidLength;
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.longestValidParentheses("(()"));
        System.out.println(solutionV202007.longestValidParentheses(")()())"));
        System.out.println(solutionV202007.longestValidParentheses(")()())(())()"));
        System.out.println(solutionV202007.longestValidParentheses("()(())"));
        // 易错用例
        System.out.println(solutionV202007.longestValidParentheses("()(()"));
    }
}

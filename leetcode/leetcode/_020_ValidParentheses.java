package leetcode.leetcode;

import java.util.Stack;

public class _020_ValidParentheses {
    private static class SolutionV2018 {
        public boolean isValid(String s) {
            Stack<String> stack = new Stack<String>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '[' || ch == '{') {
                    switch (ch) {
                        case '(':
                            stack.push(")"); break;
                        case '[':
                            stack.push("]"); break;
                        case '{':
                            stack.push("}"); break;
                        default:
                            break;
                    }
                } else {
                    if (stack.isEmpty()) {//中途栈为空说明不匹配
                        return false;
                    } else if (!stack.pop().equals(s.substring(i, i + 1))) {
                        return false;
                    }
                }
            }
            return stack.isEmpty() ? true : false;//最后栈为空才匹配
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.isValid("[(){}]]"));
    }
}

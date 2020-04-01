package leetcode.leetcode;

import java.util.Arrays;

/**
 * 有效括号的嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * @author masikkk.com
 * @create 2020-04-01 11:20
 */
public class _1111_NestingDepthOfValidParentheses {
    private static class SolutionV2020 {
        public int[] maxDepthAfterSplit(String seq) {
            if (null == seq || 0 == seq.length()) {
                return null;
            }
            int[] res = new int[seq.length()];
            int stackSize = 0;
            for (int i = 0; i < seq.length(); i++) {
                if (seq.charAt(i) == '(') {
                    // 左括号入栈，栈深度加1
                    stackSize++;
                    // 栈深度是奇数的，归为第一组，偶数的归为第二组
                    res[i] = stackSize % 2 == 1 ? 0 : 1;
                } else {
                    // 栈深度是奇数的，归为第一组，偶数的归为第二组
                    res[i] = stackSize % 2 == 1 ? 0 : 1;
                    // 右括号和栈顶抵消，栈深度减1
                    stackSize--;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
//        System.out.println(Arrays.toString(solutionV2020.maxDepthAfterSplit("(()())")));
        System.out.println(Arrays.toString(solutionV2020.maxDepthAfterSplit("()(())()")));
    }
}

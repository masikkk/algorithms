package leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 * @author masikkk.com 2020-05-28 18:09
 */
public class _394_DecodeString {
    private static class SolutionV202005 {
        public String decodeString(String s) {
            Deque<String> stack = new LinkedList<>();
            for (char ch : s.toCharArray()) {
                if (ch != ']') {
                    // 非右括号，入栈
                    stack.push(String.valueOf(ch));
                } else {
                    // 遇到右括号 ]，弹出字符直到左括号 [
                    StringBuilder cur = new StringBuilder();
                    while (!stack.isEmpty() && !stack.peek().equals("[")) {
                        cur.insert(0, stack.pop());
                    }
                    stack.pop(); // 弹出 [
                    int count = 0; // 重复的次数
                    int radix = 1;
                    // 弹出数字倒序拼成 count
                    while (!stack.isEmpty()) {
                        String str = stack.peek();
                        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                            count += (stack.pop().charAt(0) - '0') * radix;
                            radix *= 10;
                        } else {
                            break;
                        }
                    }
                    // 把 dupStr 重复 count 次，再放入栈中
                    String dupStr = cur.toString();
                    while (--count > 0) {
                        cur.append(dupStr);
                    }
                    stack.push(cur.toString());
                }
            }
            // 所有元素出栈倒序组装字符串
            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                res.append(stack.pollLast());
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.decodeString("3[a]2[bc]"));
        System.out.println(solutionV202005.decodeString("3[a2[c]]"));
        System.out.println(solutionV202005.decodeString("2[abc]3[cd]ef"));
    }
}
package problems;

import java.util.Stack;

public class _682_BaseballGame {
    private static class Solution {
        public int calPoints(String[] ops) {
            int sum = 0;
            Stack<Integer> stack = new Stack<Integer>();
            for (String op : ops) {
                try {
                    Integer score = Integer.valueOf(op);
                    sum += score;
                    stack.push(score);//valid分数入栈
                } catch (NumberFormatException e) {
                    if ("+".equals(op)) {
                        int lastValid = stack.pop();//先将栈顶弹出
                        int lastSecondValid = stack.peek();//取栈顶倒数第二个
                        sum += lastValid + lastSecondValid;
                        stack.push(lastValid);//再将栈顶push进去
                        stack.push(lastValid + lastSecondValid);//valid分数入栈
                    } else if ("D".equals(op)) {
                        sum += stack.peek() * 2;
                        stack.push(stack.peek() * 2);//valid分数入栈
                    } else if ("C".equals(op)) {
                        sum -= stack.pop();//弹出栈顶，同时扣分
                    }
                }
                System.out.println("sum: " + sum);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input1 = {"5", "2", "C", "D", "+"};
        String[] input2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(solution.calPoints(input1));
    }
}

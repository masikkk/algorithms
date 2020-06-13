package leetcode.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author masikkk.com 2020-06-11 16:54
 */
public class _739_DailyTemperatures {
    private static class SolutionV202006 {
        public int[] dailyTemperatures(int[] T) {
            if (null == T || T.length < 1) {
                return T;
            }
            // 结果数组，默认全初始化为 0
            int[] res = new int[T.length];
            // 单调递减栈，栈中存数组下标
            Deque<Integer> monoStack = new LinkedList<>();
            for (int i = 0; i < T.length; i++) {
                // 遇到比栈顶大的元素，循环出栈并计算结果
                while (!monoStack.isEmpty() && T[i] > T[monoStack.peek()]) {
                    int index = monoStack.pop();
                    res[index] = i - index;
                }
                monoStack.push(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(Arrays.toString(solutionV202006.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
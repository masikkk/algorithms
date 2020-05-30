package leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author masikkk.com 2020-05-30 21:52
 */
public class _084_LargestRectangleInHistogram {
    private static class SolutionV202005 {
        public int largestRectangleArea(int[] heights) {
            if (null == heights || heights.length < 1) {
                return 0;
            }
            if (heights.length == 1) {
                return heights[0];
            }
            int max = 0;
            // 单调递增栈
            Deque<Integer> monoStack = new LinkedList<>();
            for (int i = 0; i <= heights.length; i++) {
                // 当前下标和值
                int curIndex, curValue;
                if (i == heights.length) {
                    // 为了完成计算，数组遍历结束后向单调栈中压入一个原数组中不存在的全局最小虚拟值，下标为 heights.length，值为 -1
                    curIndex = heights.length;
                    curValue = -1;
                } else {
                    curIndex = i;
                    curValue = heights[i];
                }
                // 当栈非空，且当前值比栈顶小时，依次弹出栈中比当前值大的元素，并更新最大面积
                while (!monoStack.isEmpty() && heights[monoStack.peek()] > curValue) {
                    // 栈顶下标对应的值，即矩形的高度
                    int height = heights[monoStack.pop()];
                    // 矩形的宽度
                    int width = !monoStack.isEmpty() ? curIndex - monoStack.peek() - 1 : curIndex;
                    max = Math.max(max, height * width);
                }
                // 当前值比栈顶大，或者已弹出栈中比当前值大的元素后，当前元素下标入栈
                monoStack.push(curIndex);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.largestRectangleArea(new int[] {2,1,5,6,2,3}));
        System.out.println(solutionV202005.largestRectangleArea(new int[]{1, 1}));
    }
}
package leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * @author masikkk.com
 * @create 2020-03-03 14:45
 */
public class _155_MinStack {
    private static class MinStack {
        private Deque<Integer> stack;
        private PriorityQueue<Integer> priorityQueue;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            // 优先队列，小顶堆，堆顶永远是最小值
            priorityQueue = new PriorityQueue<>();
        }

        public void push(int x) {
            stack.push(x);
            priorityQueue.offer(x);
        }

        public void pop() {
            Integer i = stack.pop();
            // remove(x) 的时间复杂度为O(n)
            priorityQueue.remove(i);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return priorityQueue.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

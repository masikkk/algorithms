package leetcode.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @author masikkk.com
 * @create 2020-03-01 17:40
 */
public class _225_ImplementStackUsingQueues {
    private static class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        private Integer tail;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
            tail = null;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (q1.isEmpty()) {
                q2.offer(x);
            } else {
                q1.offer(x);
            }
            tail = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            tail = null;
            Queue<Integer> emptyQueue = q1.isEmpty() ? q1 : q2;
            Queue<Integer> nonEmptyQueue = q1.isEmpty() ? q2 : q1;
            int size = nonEmptyQueue.size();
            for (int i = 0; i < size - 1; i++) {
                tail = nonEmptyQueue.poll();
                emptyQueue.offer(tail);
            }
            return nonEmptyQueue.poll();
        }

        /** Get the top element. */
        public int top() {
            return tail;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            if (q1.isEmpty() && q2.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

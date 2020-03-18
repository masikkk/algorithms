package leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @author masikkk.com
 * @create 2020-03-02 10:49
 */
public class _232_ImplementQueueUsingStacks {
    private static class MyQueue {
        private Deque<Integer> nonEmptyQueue;
        private Deque<Integer> emptyQueue;
        private Integer head; // 队列头

        /** Initialize your data structure here. */
        public MyQueue() {
            nonEmptyQueue = new LinkedList<>();
            emptyQueue = new LinkedList<>();
            head = null;
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (nonEmptyQueue.isEmpty()) {
                head = x;
            }
            nonEmptyQueue.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            head = null;
            int size = nonEmptyQueue.size();
            for (int i = 0; i < size - 1; i++) {
                head = nonEmptyQueue.pop();
                emptyQueue.push(head);
            }
            int ret = nonEmptyQueue.pop();
            while (!emptyQueue.isEmpty()) {
                nonEmptyQueue.push(emptyQueue.pop());
            }
            return ret;
        }

        /** Get the front element. */
        public int peek() {
            return head;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return nonEmptyQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

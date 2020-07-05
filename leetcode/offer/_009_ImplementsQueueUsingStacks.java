package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 《剑指offer》 09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @author masikkk.com
 * @create 2020-06-30 11:57
 */
public class _009_ImplementsQueueUsingStacks {
    private static class CQueue {
        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return -1;
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

package problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 《剑指offer》面试题59 - II. 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @author masikkk.com
 * @create 2020-03-07 14:43
 */
public class Offer_059_MaxQueue {
    private static class MaxQueue {
        // 数据队列
        Queue<Integer> dataQueue;
        // 辅助最大队列
        Deque<Integer> maxQueue;
        public MaxQueue() {
            dataQueue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            // 直接返回 maxQueue 队首
            return maxQueue.isEmpty() ? -1 : maxQueue.peek();
        }

        public void push_back(int value) {
            dataQueue.offer(value);
            // maxQueue 中前面比 value 小的，都可以被value顶替，相等的要保留
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.offer(value);
        }

        public int pop_front() {
            if (dataQueue.isEmpty()) {
                return -1;
            }
            int ret = dataQueue.poll();
            // 出队元素只可能小于等于 maxQueue 队首，等于maxQueue队首时 maxQueue 也弹出
            if (maxQueue.peek().equals(ret)) {
                maxQueue.poll();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println("用例1");
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(5);
        maxQueue.push_back(3);
        maxQueue.push_back(5);
        maxQueue.push_back(10);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());

        System.out.println("用例2");
        MaxQueue maxQueue2 = new MaxQueue();
        maxQueue2.push_back(5);
        maxQueue2.push_back(4);
        maxQueue2.push_back(6);
        maxQueue2.push_back(2);
        System.out.println(maxQueue2.max_value());
        System.out.println(maxQueue2.pop_front());
        System.out.println(maxQueue2.max_value());
        System.out.println(maxQueue2.pop_front());
        System.out.println(maxQueue2.max_value());
        System.out.println(maxQueue2.pop_front());
        System.out.println(maxQueue2.max_value());
        System.out.println(maxQueue2.pop_front());
        System.out.println(maxQueue2.max_value());
        System.out.println(maxQueue2.pop_front());
    }
}

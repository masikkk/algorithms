package leetcode.leetcode;

import java.util.PriorityQueue;
import structs.ListNode;

/**
 * 数据流中的第K大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * @author masikkk.com
 * @create 2020-02-21 18:14
 */
public class _703_KthLargestElementInStream {
    private static class KthLargest {
        private int k;
        private PriorityQueue<Integer> priorityQueue; // 小顶堆

        public KthLargest(int k, int[] nums) {
            this.k = k;
            // 大小为k的小顶堆
            priorityQueue = new PriorityQueue<>(k);
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    priorityQueue.offer(nums[i]);
                } else {
                    if (nums[i] > priorityQueue.peek()) {
                        // 比堆顶（当前第k大值）大的才入堆
                        priorityQueue.poll();
                        priorityQueue.offer(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(val);
            } else if (val > priorityQueue.peek()) {
                // 比堆顶（当前第k大值）大的才入堆
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
            return priorityQueue.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, ListNode.stringToIntegerArray("[4,5,8,2]"));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

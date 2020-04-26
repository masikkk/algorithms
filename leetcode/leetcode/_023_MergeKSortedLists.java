package leetcode.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import structs.ListNode;

/**
 * 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @author masikkk.com 2020-04-26 18:00
 */
public class _023_MergeKSortedLists {
    private static class SolutionV2020 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (null == lists || lists.length < 2) {
                return null == lists || lists.length == 0 ? null : lists[0];
            }
            ListNode dumbHead = new ListNode(0);
            ListNode k = dumbHead;
            // 最小堆
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    priorityQueue.offer(lists[i]);
                }
            }
            while (!priorityQueue.isEmpty()) {
                // 选择堆顶结点即最小结点加入结果链表
                ListNode listNode = priorityQueue.poll();
                k.next = listNode;
                k = k.next;
                // 最小结点所在链表指针后移加入堆中
                if (listNode.next != null) {
                    priorityQueue.offer(listNode.next);
                }
            }
            return dumbHead.next;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        ListNode[] input1 = {ListNode.stringToListNode("[1,4,5]"), ListNode.stringToListNode("[1,3,4]"), ListNode.stringToListNode("[2,6]")};
        System.out.println(ListNode.listNodeToString(solutionV2020.mergeKLists(input1)));
        ListNode[] input2 = new ListNode[0];
        System.out.println(ListNode.listNodeToString(solutionV2020.mergeKLists(input2)));
        ListNode[] input3 = {null, null};
        System.out.println(ListNode.listNodeToString(solutionV2020.mergeKLists(input3)));
    }
}
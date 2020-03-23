package leetcode.leetcode;

import structs.ListNode;

/**
 * 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author masikkk.com
 * @create 2020-03-23 12:04
 */
public class _876_MiddleOfLinkedList {
    private static class SolutionV2020 {
        public ListNode middleNode(ListNode head) {
            if (null == head || null == head.next) {
                return head;
            }
            ListNode slow = head, fast = head;
            // 快指针每次走2步，慢指针每次走1步
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(ListNode.listNodeToString(solutionV2020.middleNode(ListNode.stringToListNode("[1,2]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.middleNode(ListNode.stringToListNode("[1,2,3]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.middleNode(ListNode.stringToListNode("[1,2,3,4,5]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.middleNode(ListNode.stringToListNode("[1,2,3,4,5,6]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.middleNode(ListNode.stringToListNode("[1,2,3,4,5,6,7,8,9,10,11]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.middleNode(ListNode.stringToListNode("[1,2,3,4,5,6,7,8,9,10,11,12]"))));

    }
}

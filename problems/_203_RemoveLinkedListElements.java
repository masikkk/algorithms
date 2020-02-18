package problems;

import structs.ListNode;

/**
 * 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_RemoveLinkedListElements {
    private static class SolutionV2018 {
        public ListNode removeElements(ListNode head, int val) {
            ListNode fakeHead = new ListNode(0);//值无用的头结点
            fakeHead.next = head;
            ListNode cur = fakeHead.next;
            ListNode prev = fakeHead;
            while (cur != null) {
                if (cur.val == val) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }
                cur = cur.next;
            }
            return fakeHead.next;
        }
    }

    private static class SolutionV2020 {
        public ListNode removeElements(ListNode head, int val) {
            if (null == head) {
                return head;
            }
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode pre = newHead, cur = head;
            while (null != cur) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
            return newHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = ListNode.stringToListNode("[6,6,6,6,6]");
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(ListNode.listNodeToString(solutionV2018.removeElements(list, 6)));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        ListNode list2 = ListNode.stringToListNode("[1,2,1]");
        System.out.println(ListNode.listNodeToString(solutionV2020.removeElements(list, 6)));
        System.out.println(ListNode.listNodeToString(solutionV2020.removeElements(list2, 1)));
    }
}

package leetcode.leetcode;

import structs.ListNode;

/**
 * 反转链表的第m到n个结点
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author masikkk.com
 * @create 2020-02-20 13:08
 */
public class _092_ReverseLinkedList2 {
    private static class SolutionV2020 {
        public ListNode reverseBetweenTwoPass(ListNode head, int m, int n) {
            if (null == head || null == head.next || m == n) {
                return head;
            }
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode pre = newHead, cur = head;
            for (int i = 1; i < m && cur != null; i++) {
                pre = cur;
                cur = cur.next;
            }
            ListNode p = cur.next;
            for (int i = 0; i < n - m && p != null; i++) {
                cur.next = p.next;
                p.next = pre.next;
                pre.next = p;
                p = cur.next;
            }
            return newHead.next;
        }

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (null == head || null == head.next || m == n) {
                return head;
            }
            // 头结点
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode pre = newHead, cur = head;
            for (int i = 1; i < n; i++) {
                if (i < m) {
                    // cur移到需要反转的起始结点m，pre是前一个结点
                    pre = cur;
                    cur = cur.next;
                } else {
                    // 从m+1到n，依次插入到pre后即可
                    ListNode temp = cur.next;
                    cur.next = cur.next.next;
                    temp.next = pre.next;
                    pre.next = temp;
                }
            }
            return newHead.next;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(ListNode.listNodeToString(solutionV2020.reverseBetween(
                ListNode.stringToListNode("[1,2,3,4,5]"), 2, 4)));
        System.out.println(ListNode.listNodeToString(solutionV2020.reverseBetween(
                ListNode.stringToListNode("[1,2]"), 1, 2)));
    }
}

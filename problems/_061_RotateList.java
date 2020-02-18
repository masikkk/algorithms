package problems;

import structs.ListNode;

/**
 * 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * @author masikkk.com
 * @create 2020-02-18 14:01
 */
public class _061_RotateList {
    private static class SolutionV2020 {
        public ListNode rotateRight(ListNode head, int k) {
            if (null == head || null == head.next) {
                return head;
            }
            // 额外的头结点
            ListNode newHead = new ListNode(0);
            newHead.next = head;

            // 链表长度
            int length = 0;
            for (ListNode p = head; p != null; length++, p = p.next) {
            }
            // k对链表长度求余
            k = k % length;
            if (k == 0) {
                return head;
            }

            // cur 比 pre 先走 k 步
            ListNode pre = head, cur = head;
            for (int i = 0, j = 0; cur.next != null; i++, j++) {
                cur = cur.next;
                if (j >= k) {
                    pre = pre.next;
                }
            }

            // pre 指向要移走的子链表的前一个结点
            // 把 pre 右侧的子链表逆置后再依次插入原链表头部即可
            ListNode reverseSubList = reverseList(pre.next);
            // pre是新结尾
            pre.next = null;
            for (ListNode p = reverseSubList; p != null;) {
                ListNode tempNext = p.next;
                p.next = newHead.next;
                newHead.next = p;
                p = tempNext;
            }

            return newHead.next;
        }

        // 递归反转链表，返回反转后链表的首结点
        private ListNode reverseList(ListNode head) {
            if (null == head || null == head.next) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
//        System.out.println(ListNode.listNodeToString(solutionV2020.reverseList(ListNode.stringToListNode("[1,2]"))));
//        System.out.println(ListNode.listNodeToString(solutionV2020.reverseList(ListNode.stringToListNode("[1,2,3,4,5]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.rotateRight(ListNode.stringToListNode("[1,2,3,4,5]"), 2)));
        System.out.println(ListNode.listNodeToString(solutionV2020.rotateRight(ListNode.stringToListNode("[1,2]"), 1)));
        System.out.println(ListNode.listNodeToString(solutionV2020.rotateRight(ListNode.stringToListNode("[0,1,2]"), 4)));
    }
}

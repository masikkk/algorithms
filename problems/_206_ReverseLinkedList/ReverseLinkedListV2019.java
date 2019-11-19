package _206_ReverseLinkedList;

/**
 * 反转链表
 * @author madaimeng.com
 * @create: 2019-11-19 12:06
 */
public class ReverseLinkedListV2019 {
    private static class Solution {
        // 使用一个新的头结点
        public ListNode reverseList(ListNode head) {
            ListNode newHead = new ListNode(0);
            while (null != head) {
                ListNode temp = head;
                head = head.next;
                temp.next = newHead.next;
                newHead.next = temp;
            }
            return newHead.next;
        }

        // 原地逆置
        public ListNode reverseListInplace(ListNode head) {
            if (null == head) {
                return head;
            }
            ListNode cur = head.next;
            head.next = null;
            while (null != cur) {
                ListNode temp = cur.next;
                cur.next = head;
                head = cur;
                cur = temp;
            }
            return head;
        }

        // 递归逆置
        public ListNode reverseListRecursive(ListNode head) {
            if (null == head || null == head.next) {
                return head;
            }
            // 逆置后 head.next 就是尾结点
            ListNode tailReversed = reverseListRecursive(head.next);
            head.next.next = head;
            head.next = null;
            return tailReversed;
        }
    }

    public static void main(String[] args) {
        String input = "[1,2,3,4,5,6,7]";
        Solution solution = new Solution();
        System.out.println("input:");
        System.out.println(ListNode.listNodeToString(ListNode.stringToListNode(input)));

        System.out.println("\nsolution1 head node:");
        System.out.println(ListNode.listNodeToString(solution.reverseList(ListNode.stringToListNode(input))));
        System.out.println(solution.reverseList(null));

        System.out.println("\nsolution2 iterative inplace :");
        System.out.println(ListNode.listNodeToString(solution.reverseListInplace(ListNode.stringToListNode(input))));
        System.out.println(solution.reverseListInplace(null));

        System.out.println("\nsolution3 recursive :");
        System.out.println(ListNode.listNodeToString(solution.reverseListRecursive(ListNode.stringToListNode(input))));
        System.out.println(solution.reverseListInplace(null));
    }
}

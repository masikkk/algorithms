package problems;

import structs.ListNode;

/**
 * 反转链表
 * @author madaimeng.com
 */
public class _206_ReverseLinkedList {
    private static class SolutionV2018 {
        //使用一个新申请的头结点
        public ListNode reverseList0(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode tempHead = new ListNode(0);//头结点
            tempHead.next = head;
            ListNode cur = head.next;
            head.next = null;
            while (cur != null) {
                ListNode curNext = cur.next;//curNext保存当前结点的下一个结点
                cur.next = tempHead.next;//当前结点插入到新链表头结点之后
                tempHead.next = cur;
                cur = curNext; //cur继续指向原链表下一个结点
            }
            return tempHead.next;
        }

        //原地逆置(不使用额外的头结点)
        public ListNode reverseList1(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode cur = head.next; //cur：当前结点
            //head：逆置后链表的首节点，初始时是原链表的首节点(逆置后的末结点)所以next设为null
            head.next = null;
            while (cur != null) {
                ListNode curNext = cur.next; //curNext：保存当前结点的下一个结点
                cur.next = head; //当前结点成为新链表表头(新链表表头挂到当前结点后)
                head = cur; //head指向新链表表头
                cur = curNext; //cur继续指向原链表下一个结点
            }
            return head;
        }

        //递归逆置
        public ListNode reverseList(ListNode head) {
            // 链表为空或只有一个结点时结束
            if (head == null || head.next == null) {
                return head;
            }
            //递归逆置head.next，newHead为逆置后的新链表
            ListNode newHead = reverseList(head.next);
            //head.next是逆置后子链表newHead的最后一个结点
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    private static class SolutionV2020 {
        // 使用一个新的头结点
        public ListNode reverseList(ListNode head) {
            ListNode newHead = new ListNode(0);
            newHead.next = null;
            while (null != head) {
                ListNode next = head.next; // 临时保存当前结点的下一个结点
                head.next = newHead.next; // 当前节点插入 newHead 之后
                newHead.next = head;
                head = next; // cur继续指向原链表下一个结点
            }
            return newHead.next;
        }

        // 原地逆置
        public ListNode reverseListInplace(ListNode head) {
            if (null == head || null == head.next) {
                return head;
            }
            ListNode cur = head.next;
            head.next = null;
            while (null != cur) {
                ListNode text = cur.next;
                cur.next = head;
                head = cur;
                cur = text;
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
        SolutionV2018 solutionV2018 = new SolutionV2018();
        String input = "[1,2,3,4,5,6,7]";
        System.out.println("原链表：" + ListNode.listNodeToString(ListNode.stringToListNode(input)));
        System.out.println("\nSolutionV2018:");
        System.out.println(ListNode.listNodeToString(solutionV2018.reverseList0(ListNode.stringToListNode(input))));
        System.out.println(ListNode.listNodeToString(solutionV2018.reverseList1(ListNode.stringToListNode(input))));
        System.out.println(ListNode.listNodeToString(solutionV2018.reverseList(ListNode.stringToListNode(input))));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println("\nSolutionV2020:");
        System.out.println("solution1 head node:");
        System.out.println(ListNode.listNodeToString(solutionV2020.reverseList(ListNode.stringToListNode(input))));
        System.out.println("solution2 iterative inplace :");
        System.out.println(ListNode.listNodeToString(solutionV2020.reverseListInplace(ListNode.stringToListNode(input))));
        System.out.println("solution3 recursive :");
        System.out.println(ListNode.listNodeToString(solutionV2020.reverseListRecursive(ListNode.stringToListNode(input))));
    }
}

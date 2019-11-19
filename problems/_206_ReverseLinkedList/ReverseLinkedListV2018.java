package _206_ReverseLinkedList;

/**
 * 反转链表
 * @author madaimeng.com
 * @create: 2018-02-05 12:06
 */
public class ReverseLinkedListV2018 {
    private static class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "[1,2,3,4,5,6,7]";
        System.out.println("原链表：" + ListNode.listNodeToString(ListNode.stringToListNode(input)));
        System.out.println(ListNode.listNodeToString(solution.reverseList0(ListNode.stringToListNode(input))));
        System.out.println(ListNode.listNodeToString(solution.reverseList1(ListNode.stringToListNode(input))));
        System.out.println(ListNode.listNodeToString(solution.reverseList(ListNode.stringToListNode(input))));
    }
}

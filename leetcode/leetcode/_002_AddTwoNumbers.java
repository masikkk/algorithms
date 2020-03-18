package leetcode.leetcode;

import structs.ListNode;

class _002_AddTwoNumbers {
	private static class SolutionV2018 {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null) {
				return null;
			}
			if (l1 == null || l2 == null) {
				return l1 == null ? l2 : l1;
			}
			ListNode head = new ListNode(0);//值无用的头结点
            ListNode prev = head;//记住上一个结点
            int carry = 0;//进位

            //l1,l2都未结束
            for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
                ListNode temp = new ListNode((l1.val + l2.val + carry) % 10);
                carry = (l1.val + l2.val + carry) / 10;
                prev.next = temp;
                prev = prev.next;
            }

            //l1,l2有一个结束，但还有进位，还需要申请新结点
            while (carry != 0) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                ListNode temp = new ListNode(sum % 10);
                carry = sum / 10;
                prev.next = temp;
                prev = prev.next;
            }

            //无进位了，只需将剩下的节点连在结果后面
            prev.next = l1 != null ? l1 : l2;
            return head.next;
        }

    }

    public static void main(String[] args) {
        String input1 = "[2,4,9,1]";
        String input2 = "[5,6,9]";
        ListNode l1 = ListNode.stringToListNode(input1);
        ListNode l2 = ListNode.stringToListNode(input2);
        System.out.println("l1:  " + ListNode.listNodeToString(l1));
        System.out.println("l2:  " + ListNode.listNodeToString(l2));
        SolutionV2018 solution = new SolutionV2018();
        ListNode sum = solution.addTwoNumbers(l1, l2);
        System.out.println("sum: " + ListNode.listNodeToString(sum));
    }
}

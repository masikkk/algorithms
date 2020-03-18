package leetcode.leetcode;

import structs.ListNode;

public class _142_LinkedListCycle2 {
    private static class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    //快指针从头开始以步长1前进，满指针继续前进
                    fast = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return slow;//下次相遇位置就是环入口
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        Solution solution = new Solution();
        if (solution.detectCycle(head) != null) {
            System.out.println(solution.detectCycle(head).val);
        } else {
            System.out.println("null");
        }
    }
}
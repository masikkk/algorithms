package problems;

import structs.ListNode;

public class _141_LinkedListCycle {
    private static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return false;
                }
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = head;
        second.next = third;
        third.next = head;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    }
}

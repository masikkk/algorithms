package _141_LinkedListCycle;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow!=null && fast!=null){
        	slow = slow.next;
        	if(fast.next !=null)
        		fast = fast.next.next;
        	else
        		return false;
        	if(slow==fast)
        		return true;
        }
        return false;
    }
}

public class LinkedListCycle {
	public static void main(String[] args){
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

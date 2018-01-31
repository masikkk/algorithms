package _142_LinkedListCycle2;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0,j=0; slow!=null && fast.next!=null; i++,j+=2){
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow==fast){
        		int circleLength = j-i;//环的长度等于相遇时快指针步长减满指针步长
        		System.out.println("环长度："+circleLength);
        		int length=0;//链表长度
        		for(slow = head; slow!=null; slow=slow.next)
        			length++;
        		int nonCircleLength = length-circleLength;
        		for(slow = head; nonCircleLength-->=0; slow = slow.next)
        		return slow;
        	}        		
        }
        return null;
    }
}

public class LinkedListCycle2 {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fourth;
		Solution solution = new Solution();
		System.out.println(solution.detectCycle(head).val);
	}
}
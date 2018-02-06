package _206_ReverseLinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
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
	//使用一个新申请的头结点
    public ListNode reverseList0(ListNode head) {
    	if(head==null)
    		return head;
        ListNode tempHead = new ListNode(0);//头结点
        tempHead.next = head;
        ListNode cur = head.next;
        head.next = null;
        while(cur!=null) {
        	ListNode curNext = cur.next;//curNext保存当前结点的下一个结点
        	cur.next = tempHead.next;//当前结点插入到新链表头结点之后
        	tempHead.next = cur;
        	cur = curNext; //cur继续指向原链表下一个结点
		}
        return tempHead.next;
    }
    
    //原地逆置(不使用额外的头结点)
    public ListNode reverseList1(ListNode head) {
    	if(head == null)
    		return head;
    	ListNode cur = head.next; //cur：当前结点
    	head.next = null; //head：逆置后链表的首节点，初始时是原链表的首节点(逆置后的末结点)所以next设为null
    	while(cur != null){
    		ListNode curNext = cur.next; //curNext：保存当前结点的下一个结点
    		cur.next = head; //当前结点成为新链表表头(新链表表头挂到当前结点后)
    		head = cur; //head指向新链表表头
    		cur = curNext; //cur继续指向原链表下一个结点
    	}
    	return head;
    }
    
    //递归逆置
    public ListNode reverseList(ListNode head) {
    	if(head==null || head.next==null)//链表为空或只有一个结点时结束
    		return head;
    	ListNode newHead = reverseList(head.next);//递归逆置head.next，newHead为逆置后的新链表
    	head.next.next = head; //head.next是逆置后子链表newHead的最后一个结点
    	head.next = null;
    	return newHead;
    }
}

public class ReverseLinkedList {
	public static void main(String[] args){
		Solution solution = new Solution();
		String input = "[1,2,3,4,5,6,7]";
		System.out.println("原链表："+listNodeToString(stringToListNode(input)));
		System.out.println(listNodeToString(solution.reverseList0(stringToListNode(input))));
		System.out.println(listNodeToString(solution.reverseList1(stringToListNode(input))));
		System.out.println(listNodeToString(solution.reverseList(stringToListNode(input))));
	}
	
	//字符串"[a1,a2,a3,a4]"转为int数组
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
	//字符串"[a1,a2,a3,a4]"转为ListNode链表
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);//无数据的头结点
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    //ListNode链表转为字符串"[a1,a2,a3,a4]"
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}

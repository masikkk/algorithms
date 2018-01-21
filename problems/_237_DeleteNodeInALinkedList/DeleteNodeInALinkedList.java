package _237_DeleteNodeInALinkedList;

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
    public void deleteNode(ListNode node) {
        while(node.next != null){
        	node.val = node.next.val;
        	if(node.next.next == null){ //倒数第二个结点
        		node.next = null;//当前结点设为尾结点
        		break;
        	}
        	node = node.next;
        }
    }
}

public class DeleteNodeInALinkedList {
	public static void main(String[] args){
		String inputString = "[1,2]";
		ListNode inputListNode = stringToListNode(inputString);
		System.out.println("origin: \n"+listNodeToString(inputListNode));
		
		ListNode deleteNode = inputListNode;//要删除的结点
		
		Solution solution = new Solution();
		solution.deleteNode(deleteNode);
		
		System.out.println("dest: \n"+listNodeToString(inputListNode));
	}

	//字符串"[1,2,3,4]"转为int数组
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
    
	//字符串"[1,2,3,4]"转为ListNode链表
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
    
    //ListNode链表转为字符串"[1,2,3,4]"
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

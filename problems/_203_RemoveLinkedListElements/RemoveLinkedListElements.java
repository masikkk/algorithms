package _203_RemoveLinkedListElements;

class ListNode{
	int val;
	ListNode next;
	public ListNode(int x) {
		val = x;
	}
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);//值无用的头结点
        fakeHead.next = head;
        ListNode cur = fakeHead.next;
        ListNode prev = fakeHead;
        while(cur!=null){
        	if(cur.val == val){
        		prev.next = cur.next;
        	}else {
				prev = cur;
			}
        	cur = cur.next;
        }
        return fakeHead.next;
    }
}

public class RemoveLinkedListElements {
	public static void main(String[] args){
		String input = "[6,6,6,6,6]";
		ListNode inputList = stringToListNode(input);
		System.out.println(listNodeToString(inputList));
		Solution solution = new Solution();
		ListNode outputList = solution.removeElements(inputList, 6);
		System.out.println(listNodeToString(inputList));
		System.out.println(listNodeToString(outputList));
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

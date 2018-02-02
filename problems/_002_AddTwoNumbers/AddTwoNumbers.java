package _002_AddTwoNumbers;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
        	return null;
        if(l1==null || l2==null)
        	return l1==null ? l2 : l1;
        ListNode head = new ListNode(0);//值无用的头结点
        ListNode prev = head;//记住上一个结点
        int carry=0;//进位
        
        //l1,l2都未结束
        for(; l1!=null && l2!=null; l1=l1.next,l2=l2.next){
        	ListNode temp = new ListNode((l1.val+l2.val+carry)%10);
        	carry = (l1.val+l2.val+carry)/10;
        	prev.next = temp;
        	prev = prev.next;
        }
        
        //l1,l2有一个结束，但还有进位，还需要申请新结点
        while(carry!=0){
        	int sum = carry;
        	if(l1!=null){
        		sum += l1.val;
        		l1 = l1.next;
        	}
        	if(l2!=null){
        		sum += l2.val;
        		l2 = l2.next;
        	}
        	ListNode temp = new ListNode(sum%10);
        	carry = sum/10;
        	prev.next = temp;
        	prev = prev.next;
        }
        
        //无进位了，只需将剩下的节点连在结果后面
        prev.next = l1!=null ? l1 : l2;
        return head.next;
    }
}

public class AddTwoNumbers {
	public static void main(String[] args){
		String input1 = "[2,4,9,1]";
		String input2 = "[5,6,9]";
		ListNode l1 = stringToListNode(input1);
		ListNode l2 = stringToListNode(input2);
		System.out.println("l1:  "+listNodeToString(l1));
		System.out.println("l2:  "+listNodeToString(l2));
		Solution solution = new Solution();
		ListNode sum = solution.addTwoNumbers(l1, l2);
		System.out.println("sum: "+listNodeToString(sum));
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

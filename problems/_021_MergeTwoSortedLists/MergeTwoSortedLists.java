package _021_MergeTwoSortedLists;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null)
        	return l1==null ? l2 : l1;
        ListNode p1=l1, p2=l2, res, resHead;
        if(p1.val<p2.val){
        	resHead = res = p1;
        	p1 = p1.next;
        }else{
        	resHead = res = p2;
        	p2 = p2.next;
        }
        while(p1!=null && p2!=null){
        	if(p1.val<p2.val){
        		res.next = p1;
        		p1 = p1.next;
        	}else{
        		res.next = p2;
        		p2 = p2.next;
        	}
        	res = res.next;
        }
        res.next = p1==null ? p2 : p1;
        return resHead;
    }
}

public class MergeTwoSortedLists {
	public static void main(String[] args){
		String l1 = "[1,1,1]";
		String l2 = "[1,1,2,3,4,5]";
		ListNode l1List = stringToListNode(l1);
		ListNode l2List = stringToListNode(l2);
		System.out.println(listNodeToString(l1List));
		System.out.println(listNodeToString(l2List));
		Solution solution = new Solution();
		ListNode mergeList = solution.mergeTwoLists(l1List, l2List);
		System.out.println(listNodeToString(mergeList));
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

package _725_SplitLinkedListInParts;

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
    public ListNode[] splitListToParts(ListNode root, int k) {   
        //计算链表长度
        int linkedListLength=0;
        for(ListNode listNode = root; listNode != null; listNode=listNode.next){
        	linkedListLength++;
        }
        
        //返回结果
        ListNode[] result = new ListNode[k];
        
        //k>n时，前n个是单节点链表，后面全为null
        if(k >= linkedListLength){
        	int i=0;
        	for(ListNode listNode = root; listNode != null; listNode=listNode.next){
        		ListNode temp = new ListNode(listNode.val);
        		result[i++] = temp;
        	}
        	while(i<k){
        		result[i++] = null;
        	}
        }else{//k<=n时
        	int bigNum = linkedListLength - k * (int)Math.floor(linkedListLength/k);//前边的长段链表个数
        	int bigSize = (int)Math.floor(linkedListLength/k) +1;//每个长段链表的size
        	int littleNum = k - bigNum;//后边的短段链表的个数
        	int littleSize = (int)Math.floor(linkedListLength/k);//短段链表的size
        	int iterator=0;//返回结果的总迭代下标
        	ListNode listNode = root;
        	
        	//生成bigNum个长段链表，放到结果数组中
        	for(int i=0; i<bigNum; i++){
        		ListNode prev = null;//此段链表的前驱结点
        		for(int j=0; j<bigSize; listNode=listNode.next,j++){//往后走bigSize个结点
        			ListNode temp = new ListNode(listNode.val);
        			if(j==0){//此段链表的头结点放入结果数组
        				result[iterator++] = temp;
        			}else{
        				prev.next = temp;
        			}
        			prev = temp;
        		}
        	}
        	
        	//生成littleNum个短段链表，放到结果数组中
        	for(int i=0; i<littleNum; i++){
        		ListNode prev = null;//此段链表的前驱结点
        		for(int j=0; j<littleSize; listNode=listNode.next,j++){//往后走littleSize个结点
        			ListNode temp = new ListNode(listNode.val);
        			if(j==0){//此段链表的头结点放入结果数组
        				result[iterator++] = temp;
        			}else{
        				prev.next = temp;
        			}
        			prev = temp;
        		}
        	}        	
        }
        return result;
    }
}

public class SplitLinkedListInParts {
	public static void main(String[] args){
		String inputString = "[1,2,3,4,5,6,7,8,9,10]";
		ListNode inputListNode = stringToListNode(inputString);
		System.out.println("origin: \n"+listNodeToString(inputListNode));
		
		Solution solution = new Solution();
		ListNode[] outputListNode = solution.splitListToParts(inputListNode, 1);
		System.out.println("After Split: ");
		for(ListNode listNode:outputListNode){
			System.out.print(listNodeToString(listNode)+",");
		}
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

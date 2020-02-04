package structs;

/**
 * 单链表
 * Definition for singly-linked list.
 * @author madaimeng.com
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    // 字符串"[a1,a2,a3,a4]"转为int数组
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    // 字符串"[a1,a2,a3,a4]"转为ListNode链表
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);//无数据的头结点
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    // ListNode链表转为字符串"[a1,a2,a3,a4]"
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }
        return sb.append("]").toString();
    }
}

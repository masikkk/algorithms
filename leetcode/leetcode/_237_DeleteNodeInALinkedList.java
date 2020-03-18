package leetcode.leetcode;

import structs.ListNode;

public class _237_DeleteNodeInALinkedList {
    private static class Solution {
        public void deleteNode(ListNode node) {
            while (node.next != null) {
                node.val = node.next.val;
                if (node.next.next == null) { //倒数第二个结点
                    node.next = null;//当前结点设为尾结点
                    break;
                }
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        String inputString = "[1,2]";
        ListNode inputListNode = ListNode.stringToListNode(inputString);
        System.out.println("origin: \n" + ListNode.listNodeToString(inputListNode));

        ListNode deleteNode = inputListNode;//要删除的结点

        Solution solution = new Solution();
        solution.deleteNode(deleteNode);

        System.out.println("dest: \n" + ListNode.listNodeToString(inputListNode));
    }
}

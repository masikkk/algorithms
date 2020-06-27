package leetcode.crack;

import java.util.HashSet;
import java.util.Set;
import structs.ListNode;

/**
 * 《程序员面试金典（第 6 版）》面试题 02.01. 移除重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * @author masikkk.com 2020-06-26 22:28
 */
public class _0201_RemoveDuplicateNode {
    private static class SolutionV202006 {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (null == head || null == head.next) {
                return head;
            }
            Set<Integer> visited = new HashSet<>();
            ListNode cur = head, pre = null;
            while (cur != null) {
                if (visited.contains(cur.val)) {
                    pre.next = cur.next;
                    cur.next = null;
                    cur = pre.next;
                } else {
                    visited.add(cur.val);
                    pre = cur;
                    cur = cur.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(ListNode.listNodeToString(solutionV202006.removeDuplicateNodes(ListNode.stringToListNode("[1, 2, 3, 3, 2, 1]"))));
        System.out.println(ListNode.listNodeToString(solutionV202006.removeDuplicateNodes(ListNode.stringToListNode("[1, 1, 1, 1, 2]"))));
        System.out.println(ListNode.listNodeToString(solutionV202006.removeDuplicateNodes(ListNode.stringToListNode("[1]"))));
        System.out.println(ListNode.listNodeToString(solutionV202006.removeDuplicateNodes(ListNode.stringToListNode("[]"))));
        System.out.println(ListNode.listNodeToString(solutionV202006.removeDuplicateNodes(ListNode.stringToListNode("[1,1]"))));
    }
}
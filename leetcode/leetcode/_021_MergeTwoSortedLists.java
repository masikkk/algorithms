package leetcode.leetcode;

import org.junit.jupiter.api.Test;
import structs.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _021_MergeTwoSortedLists {
    private static class SolutionV2018 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            ListNode p1 = l1, p2 = l2, res, resHead;
            if (p1.val < p2.val) {
                resHead = res = p1;
                p1 = p1.next;
            } else {
                resHead = res = p2;
                p2 = p2.next;
            }
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    res.next = p1;
                    p1 = p1.next;
                } else {
                    res.next = p2;
                    p2 = p2.next;
                }
                res = res.next;
            }
            res.next = p1 == null ? p2 : p1;
            return resHead;
        }
    }

    @Test
    public void testSolutionV2018() {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(ListNode.listNodeToString(solutionV2018.mergeTwoLists(
                        ListNode.stringToListNode("[1,1,1]"),
                        ListNode.stringToListNode("[1,1,2,3,4,5]"))));
    }

    private static class SolutionV2020 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            ListNode dumbHead = new ListNode(0);
            ListNode k = dumbHead;
            while (l1 != null || l2 != null) {
                if ((l1 != null && l2 != null && l1.val < l2.val) || l2 == null) {
                    k.next = l1;
                    k = l1;
                    l1 = l1.next;
                } else {
                    k.next = l2;
                    k = l2;
                    l2 = l2.next;
                }
            }
            return dumbHead.next;
        }
    }

    @Test
    public void testSolutionV2020() {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(ListNode.listNodeToString(solutionV2020.mergeTwoLists(
                        ListNode.stringToListNode("[1,1,1]"),
                        ListNode.stringToListNode("[1,1,2,3,4,5]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.mergeTwoLists(
                ListNode.stringToListNode("[1,2,4]"),
                ListNode.stringToListNode("[1,3,4]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.mergeTwoLists(
                ListNode.stringToListNode("[]"),
                ListNode.stringToListNode("[1,1]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.mergeTwoLists(
                ListNode.stringToListNode("[2,3]"),
                ListNode.stringToListNode("[]"))));
    }
}

public class _021_MergeTwoSortedLists {
    private static class Solution {
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

    public static void main(String[] args) {
        String l1 = "[1,1,1]";
        String l2 = "[1,1,2,3,4,5]";
        ListNode l1List = ListNode.stringToListNode(l1);
        ListNode l2List = ListNode.stringToListNode(l2);
        System.out.println(ListNode.listNodeToString(l1List));
        System.out.println(ListNode.listNodeToString(l2List));
        Solution solution = new Solution();
        ListNode mergeList = solution.mergeTwoLists(l1List, l2List);
        System.out.println(ListNode.listNodeToString(mergeList));
    }
}

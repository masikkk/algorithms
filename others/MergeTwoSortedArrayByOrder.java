package others;

import structs.ListNode;

/**
 * 天眼查一面
 * 已知两个有序单向链表，但是顺序未知（升序降序未知，有可能一个升序，一个降序），求合并成一个有序链表且顺序可以指定顺序
 * @author masikkk.com 2020-05-24 16:54
 */
public class MergeTwoSortedArrayByOrder {
    public static ListNode merge(ListNode list1, ListNode list2, boolean asc) {
        // 转为两个升序链表，合并，最后再根据 asc 决定返回顺序
        if (list1 != null && list1.next != null && list1.val > list1.next.val) {
            list1 = reverse(list1);
        }
        if (list2 != null && list2.next != null && list2.val > list2.next.val) {
            list2 = reverse(list2);
        }
        ListNode dumbHead = new ListNode(0);
        ListNode r = dumbHead;
        ListNode p = list1, q = list2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        r.next = p != null ? p : q;
        return asc ? dumbHead.next : reverse(dumbHead.next);
    }

    // 反转链表
    private static ListNode reverse(ListNode list) {
        ListNode dumbHead = new ListNode(0);
        ListNode cur = list;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = dumbHead.next;
            dumbHead.next = cur;
            cur = next;
        }
        return dumbHead.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.listNodeToString(merge(
                ListNode.stringToListNode("[1,2,3]"),
                ListNode.stringToListNode("[7,6,5]"),
                true
        )));
        System.out.println(ListNode.listNodeToString(merge(
                ListNode.stringToListNode("[1,2,3]"),
                ListNode.stringToListNode("[7,6,5]"),
                false
        )));
        System.out.println(ListNode.listNodeToString(merge(
                ListNode.stringToListNode("[1,2,3]"),
                ListNode.stringToListNode("[2,3,5]"),
                false
        )));
    }
}
package problems;

import java.util.Optional;
import structs.ListNode;

/**
 * 链表的交点
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author masikkk.com
 * @create 2020-02-03 17:23
 */
public class _160_IntersectionOfTwoLinkedLists {
    private static class SolutionV2020 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (null == headA || null == headB) {
                return null;
            }
            ListNode pA = headA, pB = headB;

            // 双指针法，每个指针走到结尾后跳到另一个链表头部继续，消除长度差，若有交点则第二次遍历肯定会相遇
            // 若走完都没相遇，肯定无交点
            while (null != pA || null != pB) {
                if (pA == pB) {
                    return pA;
                }
                pA = null != pA ? pA.next : headB;
                pB = null != pB ? pB.next : headA;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3
        // 4->2->3
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n3.next = n3;
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
//        n4.next = n2;
//        n4.next = n3;
        n4.next = n5;

        SolutionV2020 solutionV2020 = new SolutionV2020();
        ListNode intersect = solutionV2020.getIntersectionNode(n1, n4);
        System.out.println(Optional.ofNullable(intersect).map(ListNode::getVal).orElse(null));
    }
}

package leetcode.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import structs.ListNode;

/**
 * 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * @author masikkk.com 2020-04-14 17:13
 */
public class _445_AddTwoNumbers2 {
    private static class SolutionV2020 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            Deque<Integer> stack1 = new ArrayDeque<>();
            Deque<Integer> stack2 = new ArrayDeque<>();
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }

            int carry = 0;
            ListNode dumbHead = new ListNode(0);
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
                carry += (!stack1.isEmpty() ? stack1.pop() : 0) + (!stack2.isEmpty() ? stack2.pop() : 0);
                ListNode listNode = new ListNode(carry % 10);
                // 头插法插入到 dumbHead 之后
                listNode.next = dumbHead.next;
                dumbHead.next = listNode;
                carry /= 10;
            }
            return dumbHead.next;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(ListNode.listNodeToString(solutionV2020.addTwoNumbers(ListNode.stringToListNode("[7,2,4,3]"), ListNode.stringToListNode("[5,6,4]"))));
        System.out.println(ListNode.listNodeToString(solutionV2020.addTwoNumbers(ListNode.stringToListNode("[5]"), ListNode.stringToListNode("[5]"))));
    }
}
package leetcode.leetcode;

import structs.ListNode;

/**
 * 判断是否回文单链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author masikkk.com
 * @create 2020-02-21 15:15
 */
public class _234_PalindromeLinkedList {
    private static class SolutionV2020 {
        // 全局正向遍历指针
        private ListNode cur;
        public boolean isPalindrome(ListNode head) {
            if (null == head || null == head.next) {
                return true;
            }
            cur = head;
            return isPalindromeRecursive(head);
        }

        // 递归倒序遍历head，同时和全局正向遍历指针cur比较，返回是否相等
        private boolean isPalindromeRecursive(ListNode head) {
            if (null == head) {
               return true;
            }
            boolean isPalindrome = isPalindromeRecursive(head.next) && (head.val == cur.val);
            cur = cur.next;
            return isPalindrome;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.isPalindrome(ListNode.stringToListNode("[1,2,1]")));
        System.out.println(solutionV2020.isPalindrome(ListNode.stringToListNode("[1,2,2,1]")));
        System.out.println(solutionV2020.isPalindrome(ListNode.stringToListNode("[1,2]")));
        System.out.println(solutionV2020.isPalindrome(ListNode.stringToListNode("[1,1]")));
    }
}

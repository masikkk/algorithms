package leetcode.leetcode;

import structs.ListNode;

/**
 * K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author masikkk.com 2020-05-16 16:35
 */
public class _025_ReverseNodesInKGroup {
    private static class SolutionV202005 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (null == head || head.next == null || k < 2) {
                return head;
            }
            ListNode dumbHead = new ListNode(0);
            dumbHead.next = head;
            // lastEnd 上一段的终点， nextFirst 下一段的起点
            ListNode lastEnd = dumbHead, nextFirst;
            ListNode cur = head;
            int count = 1;
            while (cur != null) {
                if (count < k) {
                    // 向前走 k-1 步
                    cur = cur.next;
                    count++;
                } else {
                    // 记住下一段的起点
                    nextFirst = cur.next;
                    // 记住当前段的起点，逆置完之后就是当前段的终点
                    ListNode curEnd = lastEnd.next;
                    // 头插法依次将本段的 k-1 个结点插入到 lastEnd 之后
                    ListNode p = lastEnd.next.next;
                    for (int i = 0; i < k - 1; i++) {
                        ListNode next = p.next;
                        p.next = lastEnd.next;
                        lastEnd.next = p;
                        p = next;
                    }
                    // 当前段的终点指向下一段的起点
                    curEnd.next = nextFirst;
                    // 记住上一段的终点
                    lastEnd = curEnd;
                    // cur 指针归位
                    cur = nextFirst;
                    // 重新开始计数
                    count = 1;
                }
            }
            return dumbHead.next;
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(ListNode.listNodeToString(solutionV202005.reverseKGroup(
                ListNode.stringToListNode("[1,2,3,4,5]"), 2)));
        System.out.println(ListNode.listNodeToString(solutionV202005.reverseKGroup(
                ListNode.stringToListNode("[1,2,3,4,5]"), 3)));
    }
}
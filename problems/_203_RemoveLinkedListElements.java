public class _203_RemoveLinkedListElements {
    private static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode fakeHead = new ListNode(0);//值无用的头结点
            fakeHead.next = head;
            ListNode cur = fakeHead.next;
            ListNode prev = fakeHead;
            while (cur != null) {
                if (cur.val == val) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }
                cur = cur.next;
            }
            return fakeHead.next;
        }
    }

    public static void main(String[] args) {
        String input = "[6,6,6,6,6]";
        ListNode inputList = ListNode.stringToListNode(input);
        System.out.println(ListNode.listNodeToString(inputList));
        Solution solution = new Solution();
        ListNode outputList = solution.removeElements(inputList, 6);
        System.out.println(ListNode.listNodeToString(inputList));
        System.out.println(ListNode.listNodeToString(outputList));
    }
}

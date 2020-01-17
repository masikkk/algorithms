package problems;

import structs.ListNode;

public class _725_SplitLinkedListInParts {
    private static class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            //计算链表长度
            int linkedListLength = 0;
            for (ListNode listNode = root; listNode != null; listNode = listNode.next) {
                linkedListLength++;
            }

            //返回结果
            ListNode[] result = new ListNode[k];

            //k>n时，前n个是单节点链表，后面全为null
            if (k >= linkedListLength) {
                int i = 0;
                for (ListNode listNode = root; listNode != null; listNode = listNode.next) {
                    ListNode temp = new ListNode(listNode.val);
                    result[i++] = temp;
                }
                while (i < k) {
                    result[i++] = null;
                }
            } else {//k<=n时
                int bigNum = linkedListLength - k * (int) Math.floor(linkedListLength / k);//前边的长段链表个数
                int bigSize = (int) Math.floor(linkedListLength / k) + 1;//每个长段链表的size
                int littleNum = k - bigNum;//后边的短段链表的个数
                int littleSize = (int) Math.floor(linkedListLength / k);//短段链表的size
                int iterator = 0;//返回结果的总迭代下标
                ListNode listNode = root;

                //生成bigNum个长段链表，放到结果数组中
                for (int i = 0; i < bigNum; i++) {
                    ListNode prev = null;//此段链表的前驱结点
                    for (int j = 0; j < bigSize; listNode = listNode.next, j++) {//往后走bigSize个结点
                        ListNode temp = new ListNode(listNode.val);
                        if (j == 0) {//此段链表的头结点放入结果数组
                            result[iterator++] = temp;
                        } else {
                            prev.next = temp;
                        }
                        prev = temp;
                    }
                }

                //生成littleNum个短段链表，放到结果数组中
                for (int i = 0; i < littleNum; i++) {
                    ListNode prev = null;//此段链表的前驱结点
                    for (int j = 0; j < littleSize; listNode = listNode.next, j++) {//往后走littleSize个结点
                        ListNode temp = new ListNode(listNode.val);
                        if (j == 0) {//此段链表的头结点放入结果数组
                            result[iterator++] = temp;
                        } else {
                            prev.next = temp;
                        }
                        prev = temp;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String inputString = "[1,2,3,4,5,6,7,8,9,10]";
        ListNode inputListNode = ListNode.stringToListNode(inputString);
        System.out.println("origin: \n" + ListNode.listNodeToString(inputListNode));

        Solution solution = new Solution();
        ListNode[] outputListNode = solution.splitListToParts(inputListNode, 1);
        System.out.println("After Split: ");
        for (ListNode listNode : outputListNode) {
            System.out.print(ListNode.listNodeToString(listNode) + ",");
        }
    }
}

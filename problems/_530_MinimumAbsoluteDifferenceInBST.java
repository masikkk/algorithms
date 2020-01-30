package problems;

import java.util.Deque;
import java.util.LinkedList;
import structs.TreeNode;

/**
 * 非负BST的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * @author masikkk.com
 * @create 2020-01-30 15:37
 */
public class _530_MinimumAbsoluteDifferenceInBST {
    private static class SolutionV2020 {
        private Integer minDif;
        public int getMinimumDifference(TreeNode root) {
            minDif = null;
            InOrderTraverse(root);
            return minDif;
        }

        private void InOrderTraverse(TreeNode root) {
            if (null == root) {
                return;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root; // 当前节点
            TreeNode pre = null; // 前一个遍历的结点
            while (!stack.isEmpty() || null != cur) {
                while (null != cur) {
                    stack.push(cur);
                    cur = cur.left;
                }
                if (!stack.isEmpty()) {
                    cur = stack.pop();
                    if (null != pre) {
                        minDif = null != minDif ? Math.min(minDif, cur.val - pre.val) : cur.val - pre.val;
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        String input ="[1,null,3,2]";
        String input2 ="[5,4,7]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.getMinimumDifference(TreeNode.stringToTreeNode(input)));
        System.out.println(solutionV2020.getMinimumDifference(TreeNode.stringToTreeNode(input2)));
    }
}

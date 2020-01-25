package problems;

import structs.TreeNode;

/**
 * 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author masikkk.com
 * @create 2020-01-25 13:14
 */
public class _110_BalancedBinaryTree {
    private static class SolutionV2020 {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        // 计算树的高度，同时判断是否平衡二叉树。若是平衡树返回树高度，若非平衡树返回负值
        private int height(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            // 左右子树非平衡树，或者左右子树高度差大于1，则当前树不是平衡树
            if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7]";
        String input2 = "[1,2,2,3,3,null,null,4,4]";
        String input3 = "[1,2,2,3,null,null,3,4,null,null,4]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.isBalanced(TreeNode.stringToTreeNode(input)));
        System.out.println(solutionV2020.isBalanced(TreeNode.stringToTreeNode(input2)));
        System.out.println(solutionV2020.isBalanced(TreeNode.stringToTreeNode(input3)));
    }
}

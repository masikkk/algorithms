package problems;

import structs.TreeNode;

public class _543_DiameterOfBinaryTree {
    private static class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int sumDepth = treeDepth(root.left) + treeDepth(root.right);//左右子树深度之和
                int leftSumDepth = diameterOfBinaryTree(root.left);//左子树的左右子树深度之和
                int rightSumDepth = diameterOfBinaryTree(root.right);//右子树的左右子树深度之和
                return Math.max(sumDepth, Math.max(leftSumDepth, rightSumDepth));//取较大者
            }
        }

        //递归计算二叉树的深度
        private int treeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int rightDepth = treeDepth(root.right);
                int leftDepth = treeDepth(root.left);
                return rightDepth > leftDepth ? rightDepth + 1 : leftDepth + 1;
            }
        }
    }

    public static void main(String[] args) {
        String input = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println("PreOrderTraverse:");
        TreeNode.preOrderTraverse(root);
        System.out.println();

        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}

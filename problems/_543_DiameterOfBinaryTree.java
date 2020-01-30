package problems;

import structs.TreeNode;

public class _543_DiameterOfBinaryTree {
    private static class SolutionV2018 {
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

    private static class SolutionV2020 {
        private int diameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            diameter = 0;
            depth(root);
            return diameter;
        }

        // 递归计算树深度，计算过程中更新树的直径（左右子树深度之和的最大值）
        private int depth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int left = depth(root.left);
            int right = depth(root.right);
            diameter = Math.max(diameter, left + right);
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        String input = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";

        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.diameterOfBinaryTree(TreeNode.stringToTreeNode(input)));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.diameterOfBinaryTree(TreeNode.stringToTreeNode(input)));
    }
}

package leetcode.leetcode;

import structs.TreeNode;

/**
 * 反转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author masikkk.com
 * @create 2020-01-26 16:05
 */
public class _226_InvertBinaryTree {
    private static class SolutionV2020 {
        public TreeNode invertTree(TreeNode root) {
            if (null == root || (null == root.left && null == root.right)) {
                return root;
            }
            TreeNode temp = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(temp);
            return root;
        }
    }

    public static void main(String[] args) {
        String input = "[4,2,7,1,3,6,9]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode.visualize(root);
        TreeNode.visualize(solutionV2020.invertTree(root));

    }
}

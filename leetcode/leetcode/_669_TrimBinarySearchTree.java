package leetcode.leetcode;

import structs.TreeNode;

/**
 * 修剪二叉搜索树BST
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * @author masikkk.com
 * @create 2020-01-31 16:07
 */
public class _669_TrimBinarySearchTree {
    private static class SolutionV2020 {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (null == root) {
                return root;
            }
            if (root.val < L) {
                // 根小于左界，剪掉根及左子树
                return trimBST(root.right, L, R);
            }
            if (root.val > R) {
                // 根大于右届，剪掉根及右子树
                return trimBST(root.left, L, R);
            }
            if (root.val >= L && root.val <= R) {
                root.right = trimBST(root.right, L, R);
                root.left = trimBST(root.left, L, R);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        TreeNode.visualize(solutionV2020.trimBST(TreeNode.stringToTreeNode("[1,0,2]"), 1, 2));
        TreeNode bst = TreeNode.stringToTreeNode("[3,0,4,null,2,null,null,1,null]");
        TreeNode.visualize(bst);
        TreeNode.visualize(solutionV2020.trimBST(bst, 1, 3));
    }
}

package problems;

import structs.TreeNode;

/**
 * 二叉搜索树BST中查找
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @author masikkk.com
 * @create 2020-02-02 13:46
 */
public class _700_SearchBinarySearchTree {
    private static class SolutionV2020 {
        public TreeNode searchBST(TreeNode root, int val) {
            if (null == root) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            if (root.val > val) {
                return searchBST(root.left, val);
            }
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        TreeNode.visualize(solutionV2020.searchBST(TreeNode.stringToTreeNode("[4,2,7,1,3]"), 2));
        TreeNode.visualize(solutionV2020.searchBST(TreeNode.stringToTreeNode("[4,2,7,1,3]"), 5));
    }
}

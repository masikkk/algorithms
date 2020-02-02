package problems;

import structs.TreeNode;

/**
 * 单值二叉树
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 * @author masikkk.com
 * @create 2020-02-02 17:05
 */
public class _965_UnivaluedBinaryTree {
    private static class SolutionV2020 {
        public boolean isUnivalTree(TreeNode root) {
            if (null == root) {
                return true;
            }
            boolean res = true;
            if (null != root.left) {
                res = isUnivalTree(root.left) && root.val == root.left.val;
            }
            if (null != root.right) {
                res &= isUnivalTree(root.right) && root.val == root.right.val;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.isUnivalTree(TreeNode.stringToTreeNode("[1,1,1,1,1,null,1]")));
        System.out.println(solutionV2020.isUnivalTree(TreeNode.stringToTreeNode("[2,2,2,5,2]")));
    }
}

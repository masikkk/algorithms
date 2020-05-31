package leetcode.leetcode;

import structs.TreeNode;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author madaimeng.com
 * @create: 2020-01-17 14:39
 */
public class _101_SymmetricTree {
    private static class SolutionV202001 {
        public boolean isSymmetric(TreeNode root) {
            if (null == root) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        // 判断两棵树是否对称
        private boolean isSymmetric(TreeNode root1, TreeNode root2) {
            if (root1 != null && root2 != null) {
                return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
            } else {
                return root1 == root2;
            }
        }
    }
}

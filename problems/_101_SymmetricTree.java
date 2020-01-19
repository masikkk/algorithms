package problems;
/**
 * @author madaimeng.com
 * @create: 2020-01-17 14:39
 */

import structs.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class _101_SymmetricTree {
    private static class SolutionV2020 {
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

    public static void main(String[] args) {
        String input = "[1,2,2,3,4,4,3]";
        String input2 = "[1,2,2,null,3,null,3]";
        // 易错用例，左右子树的 "左根右" "右根左" 遍历完全相同，但不对称
        String input3 = "[1,2,2,2,null,2]";
        // 更易错用例
        String input4 = "[5,4,1,null,1,null,4,2,null,2,null]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode root2 = TreeNode.stringToTreeNode(input2);
        TreeNode root3 = TreeNode.stringToTreeNode(input3);
        TreeNode root4 = TreeNode.stringToTreeNode(input4);

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.isSymmetric(root));
        System.out.println();

        System.out.println(solutionV2020.isSymmetric(root2));
        System.out.println();

        System.out.println(solutionV2020.isSymmetric(root3));
        System.out.println();

        System.out.println(solutionV2020.isSymmetric(root4));
    }
}

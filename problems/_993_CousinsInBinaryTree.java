package problems;

import structs.TreeNode;

/**
 * 二叉树中的堂兄弟
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * @author masikkk.com
 */
public class _993_CousinsInBinaryTree {
    private static class SolutionV2020 {
        private Integer xLevel, yLevel;
        private Integer xParent, yParent;

        public boolean isCousins(TreeNode root, int x, int y) {
            if (null == root) {
                return false;
            }
            xLevel = null;
            yLevel = null;
            xParent = null;
            yParent = null;
            dfs(root, x, y, 0);
            return xLevel != null && xParent != null && xLevel.equals(yLevel) && !xParent.equals(yParent);
        }

        // 深度优先遍历，height是根节点root的高度
        private void dfs(TreeNode root, int x, int y, int height) {
            if (null == root) {
                return;
            }
            if (root.left != null) {
                if (root.left.val == x) {
                    xLevel = height + 1;
                    xParent = root.val;
                }
                if (root.left.val == y) {
                    yLevel = height + 1;
                    yParent = root.val;
                }
                dfs(root.left, x, y, height + 1);
            }
            if (root.right != null) {
                if (root.right.val == x) {
                    xLevel = height + 1;
                    xParent = root.val;
                }
                if (root.right.val == y) {
                    yLevel = height + 1;
                    yParent = root.val;
                }
                dfs(root.right, x, y, height + 1);
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.isCousins(TreeNode.stringToTreeNode("[1,2,3,4]"), 4, 3));
        System.out.println(solutionV2020.isCousins(TreeNode.stringToTreeNode("[1,2,3,null,4,null,5]"), 4, 5));
        System.out.println(solutionV2020.isCousins(TreeNode.stringToTreeNode("[1,2,3,null,4]"), 2, 3));
    }
}

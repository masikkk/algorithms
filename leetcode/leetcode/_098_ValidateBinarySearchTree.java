package leetcode.leetcode;

import structs.TreeNode;

/**
 * 验证二叉搜索树BST
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author masikkk.com 2020-05-05 19:51
 */
public class _098_ValidateBinarySearchTree {
    private static class SolutionV2020 {
        public boolean isValidBST(TreeNode root) {
            if (null == root) {
                return true;
            }
            return isBST(root, new int[2]);
        }

        // 判断 root 是否 BST，同时将 root 的最小最大值依次放入 minMax[]
        private boolean isBST(TreeNode root, int[] minMax) {
            if (root.left == null && root.right == null) {
                minMax[0] = root.val;
                minMax[1] = root.val;
                return true;
            }
            int min = root.val, max = root.val;
            if (root.left != null) {
                int[] leftMinMax = new int[2];
                boolean leftIsBST = isBST(root.left, leftMinMax);
                // 左子树非BST，或者左子树的最大值大于等于 root.val 时返回 false
                if (!leftIsBST || leftMinMax[1] >= root.val) {
                    return false;
                }
                min = Math.min(min, leftMinMax[0]);
            }
            if (root.right != null) {
                int[] rightMinMax = new int[2];
                boolean rightIsBST = isBST(root.right, rightMinMax);
                // 右子树非BST，或者右子树的最小值小于等于 root.val 时返回 false
                if (!rightIsBST || rightMinMax[0] <= root.val) {
                    return false;
                }
                max = Math.max(max, rightMinMax[1]);
            }
            minMax[0] = min;
            minMax[1] = max;
            return true;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.isValidBST(TreeNode.stringToTreeNode("[2,1,3]")));
        System.out.println(solutionV2020.isValidBST(TreeNode.stringToTreeNode("[5,1,4,null,null,3,6]")));
        System.out.println(solutionV2020.isValidBST(TreeNode.stringToTreeNode("[1,1]")));
        System.out.println(solutionV2020.isValidBST(TreeNode.stringToTreeNode("[5,14,null,1]")));
    }
}
package leetcode.leetcode;

import structs.TreeNode;

/**
 * 二叉树的最长同值路径
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * @author masikkk.com
 * @create 2020-02-01 12:03
 */
public class _687_LongestUnivaluePath {
    private static class SolutionV2020 {
        private int length;
        public int longestUnivaluePath(TreeNode root) {
            if (null == root) {
                return 0;
            }
            length = 0;
            depth(root);
            return length;
        }

        // 返回和根节点root同值的路径深度
        private int depth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            // 左右子树中和跟同值的高度
            int left = 0, right = 0;
            if (null != root.left) {
                int d = depth(root.left);
                left = root.left.val == root.val ? d + 1 : 0;
            }
            if (null != root.right) {
                int d = depth(root.right);
                right = root.right.val == root.val ? d + 1 : 0;
            }
            // 更新最长同值路径
            length = Math.max(length, left + right);
            return Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.longestUnivaluePath(TreeNode.stringToTreeNode("[5,4,5,1,1,5]")));
        System.out.println(solutionV2020.longestUnivaluePath(TreeNode.stringToTreeNode("[5,5,5,1,1,5]")));
        System.out.println(solutionV2020.longestUnivaluePath(TreeNode.stringToTreeNode("[1,4,5,4,4,5]")));

    }
}

package leetcode.leetcode;

import structs.TreeNode;

/**
 * 二叉树的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @author masikkk.com
 * @create 2020-02-01 16:10
 */
public class _124_BinaryTreeMaximumPathSum {
    private static class SolutionV2020 {
        private int sum;
        public int maxPathSum(TreeNode root) {
            sum = Integer.MIN_VALUE;
            treeSum(root);
            return sum;
        }

        // 返回 以root为起点的最大路径和
        private int treeSum(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int left = treeSum(root.left);
            int right = treeSum(root.right);
            // res = max(根, 左+根, 右+根)
            int res = Math.max(left + root.val, right + root.val);
            res = Math.max(res, root.val);
            // sum = max(根, 左+根, 右+根, 左+右+根, sum)
            sum = Math.max(sum, res);
            sum = Math.max(sum, left + root.val + right);
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.maxPathSum(TreeNode.stringToTreeNode("[-10,9,20,null,null,15,7]")));
        System.out.println(solutionV2020.maxPathSum(TreeNode.stringToTreeNode("[-10]")));
        // 易错用例
        System.out.println(solutionV2020.maxPathSum(TreeNode.stringToTreeNode("[2,-1]")));
    }
}

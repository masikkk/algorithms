package problems;

import structs.TreeNode;

/**
 * 二叉树的路径和
 * https://leetcode-cn.com/problems/path-sum/
 * @author masikkk.com
 * @create 2020-01-26 15:22
 */
public class _112_PathSum {
    private static class SolutionV2020 {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (null == root) {
                return false;
            }
            if (null == root.left && null == root.right) {
                return sum == root.val;
            }
            if (null == root.left || null == root.right) {
                return root.left != null ? hasPathSum(root.left, sum - root.val) : hasPathSum(root.right, sum - root.val);
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        String input = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        String input2 = "[1,2]";
        String input3 = "[]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.hasPathSum(TreeNode.stringToTreeNode(input), 22));
        System.out.println(solutionV2020.hasPathSum(TreeNode.stringToTreeNode(input2), 1));
        System.out.println(solutionV2020.hasPathSum(TreeNode.stringToTreeNode(input3), 0));
    }
}

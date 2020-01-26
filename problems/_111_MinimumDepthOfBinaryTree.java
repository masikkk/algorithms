package problems;

import structs.TreeNode;

/**
 * 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author masikkk.com
 * @create 2020-01-25 14:36
 */
public class _111_MinimumDepthOfBinaryTree {
    private static class SolutionV2020 {
        public int minDepth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            if (null == root.left && null == root.right) {
               return 1;
            }
            if (null == root.left || null == root.right) {
                return null == root.left ? minDepth(root.right) + 1 : minDepth(root.left) + 1;
            }
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7]";
        // 易错的测试用例, 叶子节点是指没有子节点的节点，所以1不是叶子节点，题目问的是根到叶子节点的最短距离，[1,2]用例中是1->2
        String input2 = "[1,2]";
        String input3 = "[1]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.minDepth(TreeNode.stringToTreeNode(input)));
        System.out.println(solutionV2020.minDepth(TreeNode.stringToTreeNode(input2)));
        System.out.println(solutionV2020.minDepth(TreeNode.stringToTreeNode(input3)));
    }
}

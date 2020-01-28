package problems;

import structs.TreeNode;

/**
 * 左叶子和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @author masikkk.com
 * @create 2020-01-27 17:37
 */
public class _404_SumOfLeftLeaves {
    private static class SolutionV2020 {
        public int sumOfLeftLeaves(TreeNode root) {
            return sumOfLeftLeaves(root, false);
        }

        private int sumOfLeftLeaves(TreeNode root, boolean left) {
            if (null == root) {
                return 0;
            }
            if (null == root.left && null == root.right && left) {
                return root.val;
            }
            return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
        }
    }

    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7]";
        // 单根结点不是左叶子
        String input2 = "[3]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.sumOfLeftLeaves(TreeNode.stringToTreeNode(input)));
        System.out.println(solutionV2020.sumOfLeftLeaves(TreeNode.stringToTreeNode(input2)));
    }
}

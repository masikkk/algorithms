package problems;

import structs.TreeNode;

/**
 * 二叉树的坡度
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 * @author masikkk.com
 * @create 2020-01-30 11:46
 */
public class _563_BinaryTreeTilt {
    private static class SolutionV2020 {
        private int tilt;
        public int findTilt(TreeNode root) {
            tilt = 0;
            sum(root);
            return tilt;
        }

        // 计算树的所有结点值的和，过程中更新树的坡度
        private int sum(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int left = sum(root.left);
            int right = sum(root.right);
            tilt += Math.abs(left - right);
            return left + right + root.val;
        }
    }

    public static void main(String[] args) {
        String input = "[1,2,3]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findTilt(TreeNode.stringToTreeNode(input)));
    }
}

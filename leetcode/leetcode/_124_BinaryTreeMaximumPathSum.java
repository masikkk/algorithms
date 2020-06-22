package leetcode.leetcode;

import org.junit.jupiter.api.Test;
import structs.TreeNode;

/**
 * 二叉树的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @author masikkk.com
 * @create 2020-02-01 16:10
 */
public class _124_BinaryTreeMaximumPathSum {
    private static class SolutionV202002 {
        private int sum;
        public int maxPathSum(TreeNode root) {
            sum = Integer.MIN_VALUE;
            treeSum(root);
            return sum;
        }

        // 返回以 root 为起点的最大路径和
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

    @Test
    public void testSolutionV202002() {
        SolutionV202002 solutionV202002 = new SolutionV202002();
        System.out.println(solutionV202002.maxPathSum(TreeNode.stringToTreeNode("[-10,9,20,null,null,15,7]")));
        System.out.println(solutionV202002.maxPathSum(TreeNode.stringToTreeNode("[-10]")));
        // 易错用例
        System.out.println(solutionV202002.maxPathSum(TreeNode.stringToTreeNode("[2,-1]")));
    }

    private static class SolutionV202006 {
        int max = Integer.MIN_VALUE; // 经过每个节点的路径和最大值
        public int maxPathSum(TreeNode root) {
            max = Integer.MIN_VALUE;
            dfs(root);
            return max;
        }

        // 深度优先遍历二叉树 root，返回 root, root+left, root+right 三者中的最大值，即以 root 为起点的单边路径的最大和，过程中更新全局最大值 max
        private int dfs(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int curMax = root.val; // 经过当前根节点的路径和最大值
            int leftMax = dfs(root.left); // 左子树单边路径的最大值
            curMax += Math.max(leftMax, 0);
            int rightMax = dfs(root.right); // 右子树单边路径的最大值
            curMax += Math.max(rightMax, 0);
            max = Math.max(curMax, max); // 更新全局最大值
            return Math.max(root.val, Math.max(root.val + leftMax, root.val + rightMax));
        }
    }

    @Test
    public void testSolutionV202006() {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.maxPathSum(TreeNode.stringToTreeNode("[1,2,3]")));
        System.out.println(solutionV202006.maxPathSum(TreeNode.stringToTreeNode("[-10,9,20,null,null,15,7]")));
        System.out.println(solutionV202006.maxPathSum(TreeNode.stringToTreeNode("[2,-1]")));
        System.out.println(solutionV202006.maxPathSum(TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]")));
    }
}

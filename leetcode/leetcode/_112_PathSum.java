package leetcode.leetcode;

import org.junit.jupiter.api.Test;
import structs.TreeNode;

/**
 * 二叉树的路径和
 * https://leetcode-cn.com/problems/path-sum/
 * @author masikkk.com
 * @create 2020-01-26 15:22
 */
public class _112_PathSum {
    private static class SolutionV202001 {
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

    @Test
    public void testSolutionV202001() {
        SolutionV202001 solutionV202001 = new SolutionV202001();
        System.out.println(solutionV202001.hasPathSum(TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]"), 22));
        System.out.println(solutionV202001.hasPathSum(TreeNode.stringToTreeNode("[1,2]"), 1));
        // 易错用例
        System.out.println(solutionV202001.hasPathSum(TreeNode.stringToTreeNode("[]"), 0));
    }

    private static class SolutionV202007 {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (null == root) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return root.val == sum;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    @Test
    public void testSolutionV202007() {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.hasPathSum(TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]"), 22));
        System.out.println(solutionV202007.hasPathSum(TreeNode.stringToTreeNode("[1,2]"), 1));
        // 易错用例
        System.out.println(solutionV202007.hasPathSum(TreeNode.stringToTreeNode("[]"), 0));
    }
}

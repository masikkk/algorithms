package problems;


import structs.TreeNode;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author masikkk.com
 * @create 2020-01-19 20:49
 */
public class _104_MaximumDepthOfBinaryTree {
    private static class SolutionV2020 {
        public int maxDepth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        String input = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(new SolutionV2020().maxDepth(root));
    }
}

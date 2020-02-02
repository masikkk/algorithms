package problems;

import structs.TreeNode;

/**
 * BST的最小差值
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * @author masikkk.com
 * @create 2020-02-02 14:02
 */
public class _783_MinimumDistanceBetweenBSTNodes {
    private static class SolutionV2020 {
        private Long minDiff;
        private TreeNode pre;
        public int minDiffInBST(TreeNode root) {
            minDiff = Long.MAX_VALUE;
            pre = null;
            inOrder(root);
            return minDiff.intValue();
        }

        // 中序遍历，过程中更新minDiff
        private void inOrder(TreeNode root) {
            if (null == root) {
                return;
            }
            inOrder(root.left);
            if (null != pre) {
                minDiff = Math.min(minDiff, (long)root.val - (long)pre.val);
            }
            pre = root;
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.minDiffInBST(TreeNode.stringToTreeNode("[4,2,6,1,3,null,null]")));
        // 易错用例，但 LeetCode oj中没有这个用例
        System.out.println(solutionV2020.minDiffInBST(TreeNode.stringToTreeNode("[2147483647,-2147483648]")));
        System.out.println(Integer.MIN_VALUE + ", " + Integer.MAX_VALUE);
    }
}

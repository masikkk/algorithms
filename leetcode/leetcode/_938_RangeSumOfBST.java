package leetcode.leetcode;

import structs.TreeNode;

/**
 * BST的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * @author masikkk.com
 * @create 2020-02-02 16:37
 */
public class _938_RangeSumOfBST {
    private static class SolutionV2020 {
        public int rangeSumBST(TreeNode root, int L, int R) {
            return dfs(root, L, R);
        }

        // 递归遍历二叉树，返回root中在[L,R]之间的结点和
        private int dfs(TreeNode root, int L, int R) {
            if (null == root) {
                return 0;
            }
            // 剪枝，剪掉根和右子树
            if (root.val > R) {
                return dfs(root.left, L, R);
            }
            // 剪枝，剪掉根和左子树
            if (root.val < L) {
                return dfs(root.right, L, R);
            }
            // 根在[L,R]之间
            return root.val + dfs(root.left, L, R) + dfs(root.right, L, R);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.rangeSumBST(
                TreeNode.stringToTreeNode("[10,5,15,3,7,null,18]"), 7, 15));
        System.out.println(solutionV2020.rangeSumBST(
                TreeNode.stringToTreeNode("[10,5,15,3,7,13,18,1,null,6]"), 6, 10));
    }
}

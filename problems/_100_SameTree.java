package problems;

import structs.TreeNode;

public class _100_SameTree {
    private static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            } else if (p != null && q != null && p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        TreeNode pLeft = new TreeNode(11);
        TreeNode pRight = new TreeNode(12);
        TreeNode qLeft = new TreeNode(11);
        TreeNode qRight = new TreeNode(12);
        p.left = pLeft;
        p.right = pRight;
        q.left = qLeft;
        q.right = qRight;
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(p, q));
    }
}

package problems;

import structs.TreeNode;

/**
 * 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class _100_SameTree {
    private static class SolutionV2018 {
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

    private static class SolutionV2020 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            } else if ( p != null && q != null ) {
                return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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

        System.out.println(new SolutionV2018().isSameTree(p, q));

        System.out.println(new SolutionV2020().isSameTree(p, q));
    }
}

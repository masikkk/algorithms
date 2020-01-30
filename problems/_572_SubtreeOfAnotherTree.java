package problems;

import structs.TreeNode;

/**
 * 二叉树的子树 https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author masikkk.com
 */
public class _572_SubtreeOfAnotherTree {
    private static class SolutionV2020 {
        // 判断t是否s的子树
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (null == s && null == t) {
                return true;
            }
            if (null == s || null == t) {
                return false;
            }
            return identity(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        // 判断两棵树是否相同
        private boolean identity(TreeNode root1, TreeNode root2) {
            if (null == root1 && null == root2) {
                return true;
            }
            if (null == root1 || null == root2) {
                return false;
            }
            boolean res = root1.val == root2.val && identity(root1.left, root2.left) && identity(root1.right, root2.right);
            return res;
        }
    }

    public static void main(String[] ars) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
//        System.out.println(solutionV2020.isSubtree(TreeNode.stringToTreeNode("[3,4,5,1,2]"),
//                TreeNode.stringToTreeNode("[4,1,2]")));
//        System.out.println(solutionV2020.isSubtree(TreeNode.stringToTreeNode("[3,4,5,1,2,null,null,null,null,0]"),
//                TreeNode.stringToTreeNode("[4,1,2]")));
        // 易错用例
        String s = "[1,null,1,null,1,2]";
        String t = "[1,2]";
        System.out.println(solutionV2020.isSubtree(TreeNode.stringToTreeNode(s), TreeNode.stringToTreeNode(t)));
    }
}

package leetcode.leetcode;

import org.junit.jupiter.api.Test;
import structs.TreeNode;

/**
 * 判断是否二叉树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author masikkk.com
 */
public class _572_SubtreeOfAnotherTree {
    private static class SolutionV202001 {
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
    
    @Test
    public void testSolutionV202001() {
        SolutionV202001 solutionV202001 = new SolutionV202001();
        System.out.println(solutionV202001.isSubtree(TreeNode.stringToTreeNode("[3,4,5,1,2]"), TreeNode.stringToTreeNode("[4,1,2]")));
        System.out.println(solutionV202001.isSubtree(TreeNode.stringToTreeNode("[3,4,5,1,2,null,null,null,null,0]"), TreeNode.stringToTreeNode("[4,1,2]")));
        System.out.println(solutionV202001.isSubtree(TreeNode.stringToTreeNode("[1,null,1,null,1,2]"), TreeNode.stringToTreeNode("[1,2]")));
    }

    private static class SolutionV202005 {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (null == s && null == t) {
                return true;
            }
            if (null == s || null == t) {
                return false;
            }

            return equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        public boolean equals(TreeNode root1, TreeNode root2) {
            if (null == root1 && null == root2) {
                return true;
            }
            if (null == root1 || null == root2) {
                return false;
            }
            return root1.val == root2.val && equals(root1.left, root2.left) && equals(root1.right, root2.right);
        }
    }

    @Test
    public void testSolutionV202005() {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.isSubtree(TreeNode.stringToTreeNode("[3,4,5,1,2]"), TreeNode.stringToTreeNode("[4,1,2]")));
        System.out.println(solutionV202005.isSubtree(TreeNode.stringToTreeNode("[3,4,5,1,2,null,null,null,null,0]"), TreeNode.stringToTreeNode("[4,1,2]")));
        System.out.println(solutionV202005.isSubtree(TreeNode.stringToTreeNode("[1,null,1,null,1,2]"), TreeNode.stringToTreeNode("[1,2]")));
    }
}

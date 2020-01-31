package problems;

import structs.TreeNode;

/**
 * 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @author masikkk.com
 * @create 2020-01-31 14:09
 */
public class _617_MergeTwoBinaryTrees {
    private static class SolutionV2020 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (null == t1 && null == t2) {
                return null;
            }
            if (null == t1 || null == t2) {
                return null == t1 ? t2 : t1;
            }
            // t1,t2都非空时，使用t1作为新的根节点
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    public static void  main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        TreeNode.visualize(solutionV2020.mergeTrees(TreeNode.stringToTreeNode("[1,3,2,5]"),
                TreeNode.stringToTreeNode("[2,1,3,null,4,null,7]")));
    }
}

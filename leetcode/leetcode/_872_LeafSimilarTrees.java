package leetcode.leetcode;

import structs.TreeNode;

/**
 * 叶子序列相同的二叉树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * @author masikkk.com
 * @create 2020-02-02 14:58
 */
public class _872_LeafSimilarTrees {
    private static class SolutionV2020 {
        StringBuilder sb1, sb2;
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            sb1 = new StringBuilder();
            sb2 = new StringBuilder();
            preOrder(root1, sb1);
            preOrder(root2, sb2);
            return sb1.toString().equals(sb2.toString());
        }

        private void preOrder(TreeNode root, StringBuilder sb) {
            if (null == root) {
                return;
            }
            // 叶子
            if (null == root.left && null == root.right) {
                sb.append(root.val);
            }
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.leafSimilar(
                TreeNode.stringToTreeNode("[3,5,1,6,2,9,8,null,null,7,4]"),
                TreeNode.stringToTreeNode("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]")
        ));
    }
}

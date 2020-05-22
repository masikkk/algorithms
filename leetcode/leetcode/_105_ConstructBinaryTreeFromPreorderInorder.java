package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;
import structs.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author masikkk.com 2020-05-22 18:44
 */
public class _105_ConstructBinaryTreeFromPreorderInorder {
    private static class SolutionV202005 {
        Map<Integer, Integer> inOrderMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (null == preorder || preorder.length < 1) {
                return null;
            }
            // 中序序列的 元素 -> 下标 之间的映射，方便直接找到根节点在中序序列里的位置(前提是元素唯一)
            inOrderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inOrderMap.put(inorder[i], i);
            }
            return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        }

        // 根据前序序列 preorder[preStart...preEnd] 和 中序序列 inorder[inStart...inEnd] 递归的构建二叉树，返回根节点
        private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart == preEnd) {
                return new TreeNode(preorder[preStart]);
            }
            TreeNode root = new TreeNode(preorder[preStart]); // 当前子树的根
            int inOrderRootIndex = inOrderMap.get(preorder[preStart]); // 根在中序序列中的下标
            if (inOrderRootIndex == inStart) { // 无左子树
                root.left = null;
            } else {
                root.left = buildTree(preorder, inorder, preStart+1, preStart + inOrderRootIndex - inStart, inStart, inOrderRootIndex-1);
            }
            if (inOrderRootIndex == inEnd) { // 无右子树
                root.right = null;
            } else {
                root.right = buildTree(preorder, inorder, preStart + inOrderRootIndex - inStart + 1, preEnd, inOrderRootIndex+1, inEnd);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        TreeNode.visualize(solutionV202005.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
    }
}
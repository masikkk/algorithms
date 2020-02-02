package problems;

import structs.TreeNode;

/**
 * BST转升序单边树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @author masikkk.com
 * @create 2020-02-02 15:22
 */
public class _897_IncreasingOrderSearchTree {
    private static class SolutionV2020 {
        public TreeNode increasingBST(TreeNode root) {
            if (null == root) {
                return null;
            }
            return postOrder(root);
        }

        // 返回root转换成的单边树的跟
        private TreeNode postOrder(TreeNode root) {
            if (null == root) {
                return null;
            }
            TreeNode left = postOrder(root.left);
            root.right = postOrder(root.right);
            // 注意一定要把left置为null，要不就乱了
            root.left = null;
            if (null != left) {
                // 返回的left是左子树转换成的单边树的跟，沿着根向右走到最右叶子
                TreeNode newRoot = left;
                while (null != left.right) {
                    left = left.right;
                }
                left.right = root;
                return newRoot;
            } else {
                return root;
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        TreeNode root = solutionV2020.increasingBST(
                TreeNode.stringToTreeNode("[5,3,6,2,4,null,8,1,null,null,null,7,9]"));
        TreeNode.inOrderTraverseRecursive(root);
        TreeNode.visualize(root);
    }
}

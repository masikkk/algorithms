package problems;

import structs.TreeNode;

/**
 * BST转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @author masikkk.com
 * @create 2020-01-29 15:48
 */
public class _538_ConvertBSTToGreaterTree {
    private static class SolutionV2020 {
        public TreeNode convertBST(TreeNode root) {
            postOrderTraverse(root, 0);
            return root;
        }

        // 递归后续遍历二叉树，greaterSum是父节点中比root值大的累加和，返回所有节点原始值的和
        private int postOrderTraverse(TreeNode root, int greaterSum) {
            if (null == root) {
                return 0;
            }
            // 叶节点
            if (null == root.left && null == root.right) {
                int res = root.val;
                root.val += greaterSum;
                return res;
            }
            // 右子树需累加： greaterSum
            int rightSum = postOrderTraverse(root.right, greaterSum);
            // 左子树需累加： 父节点 + 父节点右子树 + greaterSum
            int leftSum = postOrderTraverse(root.left, rightSum + root.val + greaterSum);
            // 子树root所有结点的原始值的和
            int sum = rightSum + leftSum + root.val;
            // 根节点需要累加： 右子树 + greaterSum
            root.val += rightSum + greaterSum;
            return sum;
        }
    }

    public static void main(String[] args) {
        String input = "[5,2,13]";
        String input2 = "[2,0,3,-4,1]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        TreeNode.visualize(solutionV2020.convertBST(TreeNode.stringToTreeNode(input)));
        TreeNode.visualize(solutionV2020.convertBST(TreeNode.stringToTreeNode(input2)));
    }
}

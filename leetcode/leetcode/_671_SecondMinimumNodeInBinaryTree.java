package leetcode.leetcode;

import structs.TreeNode;

/**
 * 二叉树中第二小的节点
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * @author masikkk.com
 * @create 2020-01-31 17:10
 */
public class _671_SecondMinimumNodeInBinaryTree {
    private static class SolutionV2020 {
        private Integer min;
        private Integer min2;
        public int findSecondMinimumValue(TreeNode root) {
            if (null == root) {
                return -1;
            }
            min = null;
            min2 = null;
            preOrderTraverse(root);
            return min2 != null ? min2 : -1;
        }

        private void preOrderTraverse(TreeNode root) {
            if (null == root) {
                return;
            }
            // 更新最小值
            if (null == min || root.val < min) {
                min2 = min;
                min = root.val;
            } else if (root.val > min && (min2 == null || root.val < min2)) {
                // 更新次小值
                min2 = root.val;
            }
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findSecondMinimumValue(TreeNode.stringToTreeNode("[2,2,5,null,null,5,7]")));
        System.out.println(solutionV2020.findSecondMinimumValue(TreeNode.stringToTreeNode("[2,2,2]")));
        System.out.println(solutionV2020.findSecondMinimumValue(TreeNode.stringToTreeNode("[2,2,2147483647]")));
    }
}

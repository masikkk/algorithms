package others;

import structs.TreeNode;

/**
 * 贝壳二面
 * 求二叉树的最大直径
 * @author masikkk.com 2020-05-20 18:58
 */
public class TreeMaxDiameter {
    private int diameter = 0;
    public int maxDiameter(TreeNode root) {
        if (null == root) {
            return 0;
        }
        this.diameter = 0;
        maxDepth(root);
        return diameter;
    }

    // 求 root 的深度，同时更新直径
    private int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            diameter = Math.max(diameter, 1);
            return 1;
        }
        int leftDepth = 0, rightDepth = 0;
        if (null != root.left) {
            leftDepth = maxDepth(root.left);
        }
        if (null != root.right) {
            rightDepth = maxDepth(root.right);
        }
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.stringToTreeNode("[1,2,3]");
        TreeMaxDiameter treeMaxDiameter = new TreeMaxDiameter();
        System.out.println(treeMaxDiameter.maxDiameter(treeNode));
    }
}
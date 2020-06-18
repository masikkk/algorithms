package leetcode.leetcode;

import java.util.LinkedList;
import structs.TreeNode;

/**
 * 从先序遍历还原二叉树
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 * @author masikkk.com 2020-06-18 21:10
 */
public class _1028_RecoverTreeFromPreorderTraversal {
    private static class SolutionV202006 {
        // 解析后的先序遍历结点 list，list 中存放的是二元组 {深度, 结点值}
        LinkedList<int[]> nodeList = new LinkedList<>();
        public TreeNode recoverFromPreorder(String s) {
            // 解析输入的先序序列字符串
            parseInput(s);
            if (nodeList.isEmpty()) {
                return null;
            }
            TreeNode root = new TreeNode(nodeList.peekFirst()[1]);
            nodeList.removeFirst();
            // 深度优先遍历构造二叉树
            dfs(root, 0);
            return root;
        }

        // 深度优先遍历构造二叉树， parent 是父节点， level 是父节点的深度
        public void dfs(TreeNode parent, int level) {
            // 当前先序序列首节点的深度等于 父节点深度+1 时，生成左孩子结点并继续 DFS
            if (!nodeList.isEmpty() && nodeList.peekFirst()[0] == level + 1) {
                TreeNode left = new TreeNode(nodeList.peekFirst()[1]);
                parent.left = left;
                nodeList.removeFirst(); // 删除访问过的序列结点
                dfs(left, level + 1);
            }
            // 当前先序序列首节点的深度等于 父节点深度+1 时，生成右孩子结点并继续 DFS
            if (!nodeList.isEmpty() && nodeList.peekFirst()[0] == level + 1) {
                TreeNode right = new TreeNode(nodeList.peekFirst()[1]);
                parent.right = right;
                nodeList.removeFirst(); // 删除访问过的序列结点
                dfs(right, level + 1);
            }
        }

        // 解析先序遍历字符串，将二元组 {深度, 结点值} 存入 list
        private void parseInput(String s) {
            for (int i = 0; i < s.length();) {
                int level = 0;
                int value = 0;
                while (i < s.length() && s.charAt(i) == '-') {
                    level++;
                    i++;
                }
                while (i < s.length() && s.charAt(i) != '-') {
                    value = value * 10 + s.charAt(i) - '0';
                    i++;
                }
                nodeList.add(new int[] {level, value});
            }
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        TreeNode.visualize(solutionV202006.recoverFromPreorder("1-2--3--4-5--6--7"));
        TreeNode.visualize(solutionV202006.recoverFromPreorder("1-2--3---4-5--6---7"));
        TreeNode.visualize(solutionV202006.recoverFromPreorder("1-401--349---90--88"));
        TreeNode.visualize(solutionV202006.recoverFromPreorder("10-7--8"));
    }
}
package leetcode.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import structs.TreeNode;

/**
 * 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @author masikkk.com 2020-04-22 10:14
 */
public class _199_BinaryTreeRightSideView {
    private static class SolutionV2020 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (null == root) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                TreeNode treeNode = new TreeNode(0);
                for (int i = 0; i < levelCount; i++) {
                    treeNode = queue.poll();
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                // 层次遍历每层的最后一个节点
                res.add(treeNode.val);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.rightSideView(TreeNode.stringToTreeNode("[1,2,3,null,5,null,4]")));
    }
}
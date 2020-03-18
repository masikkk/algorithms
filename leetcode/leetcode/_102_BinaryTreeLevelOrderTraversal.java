package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import structs.TreeNode;

/**
 * 二叉树层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author masikkk.com
 * @create 2020-01-20 15:05
 */
public class _102_BinaryTreeLevelOrderTraversal {
    private static class SolutionV2020 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (null == root) {
                return Collections.emptyList();
            }
            List<List<Integer>> resultList = new ArrayList<>();
            List<Integer> levelList = new ArrayList<>();

            // 层次间隔标识
            TreeNode flagNode = new TreeNode(0);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(flagNode);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (treeNode == flagNode) {
                    resultList.add(levelList);
                    levelList = new ArrayList<>();
                    if (queue.isEmpty()) {
                        break;
                    }
                    queue.offer(flagNode);
                } else {
                    if (null != treeNode.left) {
                        queue.offer(treeNode.left);
                    }
                    if (null != treeNode.right) {
                        queue.offer(treeNode.right);
                    }
                    levelList.add(treeNode.val);
                }
            }
            return resultList;
        }
    }

    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7]";
        String input2 = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode root2 = TreeNode.stringToTreeNode(input2);

        SolutionV2020 solutionV2020 = new SolutionV2020();
        solutionV2020.levelOrder(root).forEach(System.out::println);
        System.out.println();
        solutionV2020.levelOrder(root2).forEach(System.out::println);
    }
}

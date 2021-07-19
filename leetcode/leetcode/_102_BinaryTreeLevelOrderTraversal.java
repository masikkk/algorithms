package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import utils.ArrayUtils;
import structs.TreeNode;

/**
 * 二叉树层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author masikkk.com
 * @create 2020-01-20 15:05
 */
public class _102_BinaryTreeLevelOrderTraversal {
    private static class SolutionV202001 {
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

    @Test
    public void testSolutionV202001() {
        SolutionV202001 solutionV202001 = new SolutionV202001();
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        TreeNode.visualize(root);
        ArrayUtils.printListList(solutionV202001.levelOrder(root));

        TreeNode root2 = TreeNode.stringToTreeNode("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]");
        TreeNode.visualize(root2);
        ArrayUtils.printListList(solutionV202001.levelOrder(root2));
    }

    private static class SolutionV202005 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (null == root) {
                return new ArrayList<>(new ArrayList<>());
            }
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                // 当前层的节点数
                int levelCount = queue.size();
                List<Integer> levelList = new ArrayList<>();
                // 遍历当前层
                for (int i = 0; i < levelCount; i++) {
                    TreeNode treeNode = queue.poll();
                    levelList.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                // 遍历完一层，加入结果list
                res.add(levelList);
            }
            return res;
        }
    }

    @Test
    public void testSolutionV202005() {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        TreeNode.visualize(root);
        ArrayUtils.printListList(solutionV202005.levelOrder(root));

        TreeNode root2 = TreeNode.stringToTreeNode("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]");
        TreeNode.visualize(root2);
        ArrayUtils.printListList(solutionV202005.levelOrder(root2));
    }
}

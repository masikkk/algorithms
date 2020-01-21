package problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import structs.TreeNode;

/**
 * 二叉树自底向上层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @author masikkk.com
 * @create 2020-01-20 20:17
 */
public class _107_BinaryTreeLevelOrderTraversal2 {
    private static class SolutionV2020 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (null == root) {
                return Collections.emptyList();
            }

            // 用栈存放 自顶向下 的层次遍历结果，最后出栈即是结果
            Deque<List<Integer>> arrayDeque = new ArrayDeque<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                // 每层的结点个数
                int size = queue.size();
                List<Integer> levelList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    levelList.add(treeNode.val);
                    if (null != treeNode.left) {
                        queue.offer(treeNode.left);
                    }
                    if (null != treeNode.right) {
                        queue.offer(treeNode.right);
                    }
                }
                // 遍历完当前层
                arrayDeque.push(levelList);
            }

            // Deque 流数据就是后进先出的，相当于 Collections.reverse()
            return arrayDeque.stream().collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7]";
        String input2 = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode root2 = TreeNode.stringToTreeNode(input2);

        SolutionV2020 solutionV2020 = new SolutionV2020();
        solutionV2020.levelOrderBottom(root).forEach(System.out::println);
        System.out.println();
        solutionV2020.levelOrderBottom(root2).forEach(System.out::println);
    }
}

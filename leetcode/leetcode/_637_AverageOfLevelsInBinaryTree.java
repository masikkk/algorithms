package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import structs.TreeNode;

/**
 * 二叉树的层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * @author masikkk.com
 * @create 2020-01-31 14:34
 */
public class _637_AverageOfLevelsInBinaryTree {
    private static class SolutionV2020 {
        public List<Double> averageOfLevels(TreeNode root) {
            if (null == root) {
                return Collections.emptyList();
            }
            List<Double> res = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                // 当前层的结点个数
                int size = queue.size();
                long sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node =  queue.poll();
                    sum += node.val;
                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                }
                res.add((double)sum / size);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.averageOfLevels(TreeNode.stringToTreeNode("[3,9,20,15,7]")));
    }
}

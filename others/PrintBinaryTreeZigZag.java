package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import structs.TreeNode;

/**
 * 贝壳找房一面 之字形打印二叉树
 * @author masikkk.com 2020-05-14 19:50
 */
public class PrintBinaryTreeZigZag {
    public static void printTreeZig(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean forward = true;
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            // 遍历当前层所有结点
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.val);
                if (null != treeNode.left) {
                    queue.offer(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.offer(treeNode.right);
                }
            }
            if (!forward) {
                Collections.reverse(levelList);
            }
            levelList.forEach(node -> System.out.print(node + ","));
            System.out.println();
            forward = !forward;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,4,5,6,7]");
        TreeNode.visualize(root);
        printTreeZig(root);
    }
}
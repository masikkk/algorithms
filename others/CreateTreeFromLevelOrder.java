package others;

import java.util.LinkedList;
import java.util.Queue;
import structs.TreeNode;

/**
 * 天眼查一面
 * 已知一颗完全二叉树的广度优先遍历顺序是ABCDEFGHK, 求还原这颗完全二叉树
 * @author masikkk.com 2020-05-24 16:49
 */
public class CreateTreeFromLevelOrder {
    public static TreeNode createBalanceTree(int[] data) {
        if (null == data || data.length < 1) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data[0]);
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < data.length) {
            TreeNode node = queue.poll();
            TreeNode left = new TreeNode(data[i++]);
            node.left = left;
            queue.offer(left);
            if (i < data.length) {
                TreeNode right = new TreeNode(data[i++]);
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = createBalanceTree(new int[] {1,2,3,4,5,6,7});
        TreeNode.visualize(root);
    }
}
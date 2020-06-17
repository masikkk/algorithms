package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import structs.TreeNode;

/**
 * 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author masikkk.com 2020-06-16 18:32
 */
public class _297_SerializeAndDeserializeBinaryTree {
    private static class Codec {
        private String prefix = "[";
        private String suffix = "]";

        // 层次序列化
        public String serialize(TreeNode root) {
            if (null == root) {
                return wrap(Collections.emptyList());
            }
            List<String> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            res.add(String.valueOf(root.val));

            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                boolean hasNonNull = false; // 当前层是否有非 null 结点
                List<String> levelList = new ArrayList<>();
                for (int i = 0; i < levelCount; i++) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.left != null) {
                        hasNonNull = true;
                        levelList.add(String.valueOf(treeNode.left.val));
                        queue.offer(treeNode.left);
                    } else {
                        levelList.add("null");
                    }
                    if (treeNode.right != null) {
                        hasNonNull = true;
                        levelList.add(String.valueOf(treeNode.right.val));
                        queue.offer(treeNode.right);
                    } else {
                        levelList.add("null");
                    }
                }
                // 当前层并非全是 null 时才需要序列化
                if (hasNonNull) {
                    res.addAll(levelList);
                }
            }
            return wrap(res);
        }

        // 层次反序列化
        public TreeNode deserialize(String data) {
            data = unWrap(data);
            if (data.equals("")) {
                return null;
            }
            String[] strs = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
            queue.offer(root);

            for (int i = 1; i < strs.length && !queue.isEmpty(); i++) {
                TreeNode treeNode = queue.poll();
                if (!strs[i].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                    treeNode.left = left;
                    queue.offer(left);
                }
                i++;
                if (i < strs.length && !strs[i].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
                    treeNode.right = right;
                    queue.offer(right);
                }
            }

            return root;
        }

        private String wrap(List<String> input) {
            return prefix + String.join(",", input) + suffix;
        }

        private String unWrap(String input) {
            return input.substring(1, input.length() - 1);
        }
    }

    @Test
    public void testCodec() {
        Codec codec = new Codec();
        TreeNode.visualize(codec.deserialize(codec.serialize(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]"))));
        TreeNode.visualize(codec.deserialize(codec.serialize(TreeNode.stringToTreeNode("[3,null,2]"))));
        TreeNode.visualize(codec.deserialize(codec.serialize(TreeNode.stringToTreeNode("[3,null,2,null,5]"))));
    }
}
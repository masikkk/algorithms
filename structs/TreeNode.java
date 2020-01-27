package structs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树结点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    // 递归先序遍历二叉树
    public static void preOrderTraverseRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        preOrderTraverseRecursive(root.left);
        preOrderTraverseRecursive(root.right);
    }

    // 非递归现需遍历二叉树
    public static void preOrderTraverseIterative(TreeNode root) {
        if (null == root) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty() || null != cur) {
            while (null != cur) {
                System.out.print(cur.val + ",");
                cur = cur.left;
                if (null != cur) {
                    stack.push(cur);
                }
            }
            cur = stack.pop();
            if (null != cur.right) {
                stack.push(cur.right);
            }
            cur = cur.right;
        }
    }

    // 递归中序遍历二叉树
    public static void midOrderTraverseRecursive(TreeNode root) {
        if (null == root) {
            return;
        }
        midOrderTraverseRecursive(root.left);
        System.out.print(root.val + ",");
        midOrderTraverseRecursive(root.right);
    }

    // 非递归中序遍历二叉树
    public static void midOrderTraverseIterative(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek();
            while (null != currentNode) {
                currentNode = currentNode.left;
                stack.push(currentNode);
            }
            stack.pop(); // pop null
            if (stack.isEmpty()) {
                return;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.val + ",");
            stack.push(currentNode.right);
        }
    }

    // 递归后序遍历
    public static void postOrderTraverseRecursive(TreeNode root) {
        if (null == root) {
            return;
        }
        postOrderTraverseRecursive(root.left);
        postOrderTraverseRecursive(root.right);
        System.out.print(root.val + ",");
    }

    // 非递归后序遍历
    public static void postOrderTraverseIterative(TreeNode root) {
        if (null == root) {
            return;
        }

    }

    // 层次遍历
    public static void levelTraverse(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (null != queue.peek()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.val + ",");
            if (null != treeNode.left) {
                queue.offer(treeNode.left);
            }
            if (null != treeNode.right) {
                queue.offer(treeNode.right);
            }
        }
    }

    // 二叉树可视化
    public static void visualize(TreeNode root) {
        if (null == root) {
            return;
        }
        List<List<StringBuilder>> levelsList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每层的结点个数
            int size = queue.size();
            // 是否最后一层
            boolean lastLevel = true;
            List<StringBuilder> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                // 除最左侧结点外，前面加空格
                if (i > 0) {
                    level.add(new StringBuilder("  "));
                }
                if (null != treeNode) {
                    // 队列中全是null说明是最后一层
                    lastLevel = false;
                    level.add(new StringBuilder(String.format("%02d", treeNode.val)));
                    queue.offer(treeNode.left);
                    queue.offer(treeNode.right);
                } else {
                    level.add(new StringBuilder("##"));
                    // 队列中放入null表示空结点
                    queue.offer(null);
                    queue.offer(null);
                }
            }
            // 遍历完当前层
            if (lastLevel) {
                break;
            }

            // 前面所有层的每个元素前依次插入空格
            int height = levelsList.size();
            for (int i = 1; i <= height; i++) {
                List<StringBuilder> sbList = levelsList.get(i-1);
                for (StringBuilder sb : sbList) {
                    // 第i层每个元素前插入 height-i 个空格
                    for (int j = 0; j < Math.pow(2, height - i); j++) {
                        sb.insert(0, "  ");
                    }
                }
            }
            levelsList.add(level);
        }

        // 打印
        levelsList.forEach(le -> {
            le.forEach(System.out::print);
            System.out.println();
        });
        System.out.println();
    }

    // 根据层次遍历序列创建二叉树
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String input = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
        System.out.println("LeetCode二叉树层次遍历数组：");
        System.out.println(input);
        TreeNode root = TreeNode.stringToTreeNode(input);

        System.out.println("层次遍历：");
        levelTraverse(root);
        System.out.println();

        System.out.println("递归先序遍历：");
        TreeNode.preOrderTraverseRecursive(root);
        System.out.println();

        System.out.println("非递归先序遍历：");
        TreeNode.preOrderTraverseIterative(root);
        System.out.println();

        System.out.println("递归中序遍历：");
        TreeNode.midOrderTraverseRecursive(root);
        System.out.println();

        System.out.println("非递归中序遍历：");
        TreeNode.midOrderTraverseIterative(root);
        System.out.println();

        System.out.println("递归后序遍历：");
        TreeNode.postOrderTraverseRecursive(root);
        System.out.println();

        System.out.println("可视化：");
        visualize(TreeNode.stringToTreeNode("[3,9,20]"));
        visualize(TreeNode.stringToTreeNode("[3,9,20,1]"));
        visualize(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]"));
        visualize(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7,null,null,null,8]"));
        visualize(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7,null,null,null,8,1]"));
        visualize(root);
    }
}

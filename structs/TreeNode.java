package structs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    // 层次遍历
    public static void levelTraverse(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
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
        System.out.println("input level string:");
        System.out.println(input);
        TreeNode root = TreeNode.stringToTreeNode(input);

        System.out.println("Level Traverse:");
        levelTraverse(root);
        System.out.println();

        System.out.println("Pre Order Traverse Recursive:");
        TreeNode.preOrderTraverseRecursive(root);
        System.out.println();

        System.out.println("Mid Order Traverse Recursive:");
        TreeNode.midOrderTraverseRecursive(root);
        System.out.println();

        System.out.println("Mid Order Traverse Iterative:");
        TreeNode.midOrderTraverseIterative(root);
        System.out.println();
    }
}

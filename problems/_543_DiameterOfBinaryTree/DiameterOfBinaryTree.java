package _543_DiameterOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
    	if(root == null)
    		return 0;
    	else{
    		int sumDepth = treeDepth(root.left) + treeDepth(root.right);//左右子树深度之和
    		int leftSumDepth = diameterOfBinaryTree(root.left);//左子树的左右子树深度之和
    		int rightSumDepth = diameterOfBinaryTree(root.right);//右子树的左右子树深度之和
    		return Math.max(sumDepth, Math.max(leftSumDepth, rightSumDepth));//取较大者
    	}
    }
    
    //递归计算二叉树的深度
    private int treeDepth(TreeNode root){
    	if(root == null){
    		return 0;
    	}else{
    		int rightDepth = treeDepth(root.right);
    		int leftDepth = treeDepth(root.left);
    		return rightDepth>leftDepth ? rightDepth+1 : leftDepth+1;
    	}
    }
}

public class DiameterOfBinaryTree {
	public static void main(String[] args){
		String input="[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
		TreeNode root = stringToTreeNode(input);
		System.out.println("PreOrderTraverse:");
		preOrderTraverse(root);
		System.out.println();
		
		Solution solution = new Solution();
		System.out.println(solution.diameterOfBinaryTree(root));
	}
	
	//递归先序遍历二叉树
	private static void preOrderTraverse(TreeNode root){
		if(root == null)
			return;
		System.out.print(root.val+",");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	
	//根据层次遍历序列创建二叉树
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
        while(!nodeQueue.isEmpty()) {
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
}

package leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import structs.TreeNode;

/**
 * BST树的最低公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author masikkk.com
 * @create 2020-01-26 16:41
 */
public class _235_LowestCommonAncestorOfBST {
    private static class SolutionV2020 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (null == root) {
                return root;
            }
            if (containNodes(root.left, p, q)) {
                return lowestCommonAncestor(root.left, p, q);
            } else if(containNodes(root.right, p, q)) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }

        // 非递归先序遍历，判断root中是否包含p和q
        // 由于题目规定是BST树，其实可通过直接比较pq和root的结点值来判断
        public boolean containNodes(TreeNode root, TreeNode p, TreeNode q) {
            if (null == root) {
                return false;
            }
            boolean hasP = false;
            boolean hasQ = false;
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            TreeNode cur = root;
            while (!stack.isEmpty() || null != cur) {
                while (null != cur) {
                    hasP = cur == p || hasP;
                    hasQ = cur == q || hasQ;
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
            return hasP && hasQ;
        }
    }

    public static void main(String[] args) {
        String input = "[6,2,8,0,4,7,9,null,null,3,5]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        SolutionV2020 solutionV2020 = new SolutionV2020();
//        System.out.println(solutionV2020.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(solutionV2020.lowestCommonAncestor(root, root.left, root.left.right).val);
    }
}

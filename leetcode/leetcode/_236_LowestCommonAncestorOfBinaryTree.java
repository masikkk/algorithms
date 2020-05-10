package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import structs.TreeNode;

/**
 * 二叉树的最低公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author masikkk.com
 * @create 2020-01-27 15:23
 */
public class _236_LowestCommonAncestorOfBinaryTree {
    private static class SolutionV202001 {
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

    @Test
    public void testSolutionV202001() {
        SolutionV202001 solutionV202001 = new SolutionV202001();
        String input = "[6,2,8,0,4,7,9,null,null,3,5]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(solutionV202001.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(solutionV202001.lowestCommonAncestor(root, root.left, root.left.right).val);
    }

    private static class SolutionV202005 {
        private List<TreeNode> pAncestorList, qAncestorList;
        private TreeNode p, q;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.p = p;
            this.q = q;

            // 先序遍历并记录 p,q 的祖先序列
            preOrder(root, new LinkedList<>());
            TreeNode lowestCommonAncestor = new TreeNode(0);

            // 遍历 p,q 的祖先序列，找下标最大的公共结点
            for (int i = 0, j = 0; i < pAncestorList.size() && j < qAncestorList.size(); i ++, j++) {
                if (pAncestorList.get(i).val == qAncestorList.get(j).val) {
                    lowestCommonAncestor = pAncestorList.get(i);
                }
            }
            return lowestCommonAncestor;
        }

        // 先序遍历二叉树， 遇到 p,q 时记录其祖先序列， ancestorList 是 root 的祖先序列
        public void preOrder(TreeNode root, Deque<TreeNode> ancestorList) {
            if (root == null) {
                return;
            }
            ancestorList.addLast(root);
            if (root.val == p.val) {
                pAncestorList = new ArrayList<>(ancestorList);
            }
            if (root.val == q.val) {
                qAncestorList = new ArrayList<>(ancestorList);
            }
            if (Objects.nonNull(root.left)) {
                preOrder(root.left, ancestorList);
                // 注意回溯
                ancestorList.removeLast();
            }
            if (Objects.nonNull(root.right)) {
                preOrder(root.right, ancestorList);
                // 注意回溯
                ancestorList.removeLast();
            }
        }
    }

    @Test
    public void testSolutionV202005() {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        TreeNode root = TreeNode.stringToTreeNode("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode.visualize(root);
        System.out.println(solutionV202005.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(solutionV202005.lowestCommonAncestor(root, root.left, root.left.right).val);
    }
}

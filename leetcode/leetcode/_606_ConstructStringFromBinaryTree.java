package leetcode.leetcode;

import structs.TreeNode;

/**
 * 二叉树转括号字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * @author masikkk.com
 * @create 2020-01-30 12:16
 */
public class _606_ConstructStringFromBinaryTree {
    private static class SolutionV2020 {
        public String tree2str(TreeNode t) {
            if (null == t) {
                return "";
            }
            if (null == t.left && null == t.right) {
                return String.valueOf(t.val);
            }
            StringBuilder sb = new StringBuilder(String.valueOf(t.val));
            sb.append("(").append(tree2str(t.left)).append(")");
            if (null != t.right) {
                sb.append("(").append(tree2str(t.right)).append(")");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String input = "[1,2,3,4]";
        String input2 = "[1,2,3,null,4]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.tree2str(TreeNode.stringToTreeNode(input)));
        System.out.println(solutionV2020.tree2str(TreeNode.stringToTreeNode(input2)));
    }
}

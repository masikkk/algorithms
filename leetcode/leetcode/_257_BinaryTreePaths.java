package leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;
import structs.TreeNode;

/**
 * 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * @author masikkk.com
 * @create 2020-01-27 16:04
 */
public class _257_BinaryTreePaths {
    private static class SolutionV2020 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (null == root) {
                return result;
            }
            if (null == root.left && null == root.right) {
                result.add(String.valueOf(root.val));
                return result;
            }
            binaryTreePaths(root.left).forEach(subPath -> result.add(root.val + "->" + subPath));
            binaryTreePaths(root.right).forEach(subPath -> result.add(root.val + "->" + subPath));
            return result;
        }
    }

    public static void main(String[] args) {
        String input = "[1,2,3,null,5]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        SolutionV2020 solutionV2020 = new SolutionV2020();
        solutionV2020.binaryTreePaths(root).forEach(System.out::println);
    }
}

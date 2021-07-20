package temp;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不同的二叉搜索树 II
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @author masikkk.com
 * @create: 2020-07-21 22:54
 */
public class _095_UniqueBinarySearchTrees2 {
    private static class SolutionV202007 {
        public List<TreeNode> generateTrees(int n) {
            if (n < 1) {
                return Collections.emptyList();
            }
            return generate(1, n);
        }

        private List<TreeNode> generate(int left, int right) {
            List<TreeNode> result = new ArrayList<>();
            if (left > right) {
                result.add(null);
                return result;
            }
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftTrees = generate(left, i - 1);
                List<TreeNode> rightTrees = generate(i + 1, right);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        result.add(new TreeNode(i, leftTree, rightTree));
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        solutionV202007.generateTrees(3).forEach(TreeNode::visualize);
    }
}

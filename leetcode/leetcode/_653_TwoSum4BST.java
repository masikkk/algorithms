package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;
import structs.TreeNode;

/**
 * 两数之和4-输入是BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * @author masikkk.com
 * @create 2020-01-31 15:31
 */
public class _653_TwoSum4BST {
    private static class SolutionV2020 {
        public boolean findTarget(TreeNode root, int k) {
            Map<Integer, Boolean> map = new HashMap<>();
            return preOrderTraverse(root, k, map);
        }

        private boolean preOrderTraverse(TreeNode root, int k, Map<Integer, Boolean> map) {
            if (null == root) {
                return false;
            }
            if (map.containsKey(k - root.val)) {
                return true;
            }
            map.put(root.val, false);
            return preOrderTraverse(root.left, k, map) || preOrderTraverse(root.right, k, map);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findTarget(TreeNode.stringToTreeNode("[5,3,6,2,4,null,7]"), 9));
        System.out.println(solutionV2020.findTarget(TreeNode.stringToTreeNode("[5,3,6,2,4,null,7]"), 28));
    }
}

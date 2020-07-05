package leetcode.leetcode;

import org.junit.jupiter.api.Test;
import structs.TreeNode;

/**
 * 升序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author masikkk.com
 * @create 2020-01-21 12:57
 */
public class _108_ConvertSortedArrayToBinarySearchTree {
    private static class SolutionV202001 {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (null == nums) {
                return null;
            }
            return sortedArrayToBSTRecursive(nums, 0, nums.length -1 );
        }

        private TreeNode sortedArrayToBSTRecursive(int[] nums, int left ,int right) {
            if (left > right) {
                return null;
            }
            if (left == right) {
                return new TreeNode(nums[left]);
            }
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBSTRecursive(nums, left, mid - 1);
            root.right = sortedArrayToBSTRecursive(nums, mid + 1, right);
            return root;
        }
    }

    @Test
    public void testSolutionV202001() {
       int[] nums = {-10,-3,0,5,9};
       SolutionV202001 solutionV202001 = new SolutionV202001();
       TreeNode root = solutionV202001.sortedArrayToBST(nums);
       TreeNode.visualize(root);
       TreeNode.inOrderTraverseRecursive(root);
    }

    private static class SolutionV202007 {
        public TreeNode sortedArrayToBST(int[] nums) {
            return toBST(nums, 0, nums.length - 1);
        }

        // 递归的将 nums[left...right] 转换为 bst
        private TreeNode toBST(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            if (left == right) {
                return new TreeNode(nums[left]);
            }
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = toBST(nums, left, mid - 1);
            root.right = toBST(nums, mid + 1, right);
            return root;
        }
    }

    @Test
    public void testSolutionV202007() {
        int[] nums = {-10,-3,0,5,9};
        SolutionV202007 solutionV202007 = new SolutionV202007();
        TreeNode root = solutionV202007.sortedArrayToBST(nums);
        TreeNode.visualize(root);
        TreeNode.inOrderTraverseRecursive(root);
    }
}

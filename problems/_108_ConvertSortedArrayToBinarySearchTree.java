package problems;

import structs.TreeNode;

/**
 * 升序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author masikkk.com
 * @create 2020-01-21 12:57
 */
public class _108_ConvertSortedArrayToBinarySearchTree {
    private static class SolutionV2020 {
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

    public static void main(String[] args) {
       int[] nums = {-10,-3,0,5,9};
       SolutionV2020 solutionV2020 = new SolutionV2020();
       TreeNode root = solutionV2020.sortedArrayToBST(nums);
       TreeNode.visualize(root);
       TreeNode.midOrderTraverseRecursive(root);
    }
}

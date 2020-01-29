package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import structs.TreeNode;

/**
 * 二叉搜索树BST中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @author masikkk.com
 * @create 2020-01-28 17:33
 */
public class _501_FindModeInBinarySearchTree {
    private static class SolutionV2020 {
        public int[] findMode(TreeNode root) {
            if (null == root) {
                return new int[0];
            }
            // 结点值及对应的出现次数map
            Map<Integer, Integer> map = new TreeMap<>();
            preOrderTraverse(root, map);
            // 出现次数与结点值map，出现次数相同的放入list，利用 TreeMap 自动按 key 升序排列的性质，最后一个kv就是结果
            TreeMap<Integer, List<Integer>> countMap = new TreeMap<>();
            map.forEach((k, v) -> {
                List<Integer> list = countMap.getOrDefault(v, new ArrayList<>());
                list.add(k);
                countMap.put(v, list);
            });
            List<Integer> result = countMap.get(countMap.lastKey());
            System.out.println(result);
            return result.stream().mapToInt(i -> i).toArray();
        }

        private void preOrderTraverse(TreeNode root, Map<Integer, Integer> map) {
            if (null == root) {
                return;
            }
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            preOrderTraverse(root.left, map);
            preOrderTraverse(root.right, map);
        }
    }

    public static void main(String[] args) {
        String input = "[1,null,2,2]";
        String input2 = "[1,2,3,4]";
        String input3 = "[]";
        SolutionV2020 solutionV2020 = new SolutionV2020();
        solutionV2020.findMode(TreeNode.stringToTreeNode(input));
        solutionV2020.findMode(TreeNode.stringToTreeNode(input2));
        solutionV2020.findMode(TreeNode.stringToTreeNode(input3));
    }
}

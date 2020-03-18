package leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import javafx.util.Pair;
import structs.TreeNode;

/**
 * 从根到叶的二进制数之和
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 * @author masikkk.com
 * @create 2020-02-02 17:39
 */
public class _1022_SumOfRootToLeafBinaryNumbers {
    private static class SolutionV2020 {
        public int sumRootToLeaf(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int sum = 0;
            // pair的右值是树结点的parent所表示的二进制数和
            Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(root, 0));
            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                // 当前节点node表示的二进制数和
                int thisSum = pair.getValue() * 2 + node.val;
                // node是叶子节点，累加和到sum
                if (null == node.left && null == node.right) {
                    sum += thisSum;
                }
                if (null != node.left) {
                    queue.offer(new Pair<>(node.left, thisSum));
                }
                if (null != node.right) {
                    queue.offer(new Pair<>(node.right, thisSum));
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.sumRootToLeaf(TreeNode.stringToTreeNode("[1,0,1,0,1,0,1]")));
    }
}

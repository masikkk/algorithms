package leetcode.leetcode;

/**
 * 有序矩阵中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @author masikkk.com
 * @create: 2020-07-02 20:12
 */
public class _378_KthSmallestElementInSortedMatrix {
    private static class SolutionV202007 {
        public int kthSmallest(int[][] matrix, int k) {
            int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[0].length - 1];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int lessCount = countLess(matrix, mid); // 小于等于 mid 的元素个数
                if (lessCount < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        // 统计有序矩阵 matrix 中小于等于 target 的元素个数
        private int countLess(int[][] matrix, int target) {
            int count = 0;
            // 从左下角开始往右上角遍历
            int i = matrix.length - 1, j = 0;
            while (i >= 0 && j < matrix[0].length) {
                if (matrix[i][j] <= target) {
                    // 小于等于 target，往右走，第 j 列上面的元素肯定也都比 target 小，所以 count 加 i + 1
                    count += i + 1;
                    j++;
                } else {
                    // 大于 target，往上走
                    i--;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.kthSmallest(new int[][]{
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}}, 8));
        System.out.println(solutionV202007.kthSmallest(new int[][]{
                {1}}, 1));
        System.out.println(solutionV202007.kthSmallest(new int[][]{
                {1, 1},
                {1, 2}}, 2));
        System.out.println(solutionV202007.kthSmallest(new int[][]{
                {1, 2},
                {1, 3}}, 3));
    }
}

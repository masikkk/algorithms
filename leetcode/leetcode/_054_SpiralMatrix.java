package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 * @author masikkk.com 2020-06-05 18:25
 */
public class _054_SpiralMatrix {
    private static class SolutionV202006 {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (null == matrix || matrix.length < 1 || matrix[0].length < 1) {
                return Collections.emptyList();
            }
            int rows = matrix.length, columns = matrix[0].length;

            // 要遍历的圈数
            int circles = (Math.min(matrix.length, matrix[0].length) + 1) / 2;

            List<Integer> res = new ArrayList<>();
            for (int k = 0; k < circles; k++) {
                // 先确定上、下、左、右四个边界值，之后就好遍历了
                int left = k, right = columns - 1 - k, up = k, down = rows - 1 - k;
                // 上
                for (int j = left; j <= right; j++) {
                    res.add(matrix[up][j]);
                }
                // 右
                for (int i = up + 1; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                // 下，down == up 时表示是单行数据，如果下面再横着遍历一次就重复了
                for (int j = right - 1; j >= left && down > up; j--) {
                    res.add(matrix[down][j]);
                }
                // 左，left == right 时表示是单列数据，如果左侧再遍历一次就重复了
                for (int i = down - 1; i >= up + 1 && left < right; i--) {
                    res.add(matrix[i][left]);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.spiralOrder(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}));
        System.out.println(solutionV202006.spiralOrder(new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}}));
        System.out.println(solutionV202006.spiralOrder(new int[][] {{1, 2}}));
        System.out.println(solutionV202006.spiralOrder(new int[][] {{1}, {2}, {3}}));
        System.out.println(solutionV202006.spiralOrder(new int[][] {
                {1,2,3,4,5},
                {6,7,8,9,10}}));
    }
}
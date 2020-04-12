package leetcode.crack;

import structs.ArrayUtils;

/**
 * 《程序员面试金典（第 6 版）》面试题 01.07. 旋转矩阵
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * @author masikkk.com
 * @create 2020-04-07 13:56
 */
public class _0107_RotateMatrix {
    private static class SolutionV2020 {
        public void rotate(int[][] matrix) {
            if (null == matrix || matrix.length < 2) {
                return;
            }
            // 层数（圈数）
            int levelCount = matrix.length / 2;
            // 从最外圈（层）开始，依次把每圈顺时针旋转90度
            for (int i = 0; i< levelCount; i++) {
                rotateCircle(matrix, i, i, matrix.length - 1 -i, matrix.length - 1 - i);
            }
        }

        // 把正方形 (x1,y1) (x2,y2) 上的元素做顺时针 90 度旋转
        private void rotateCircle(int[][] matrix, int x1, int y1, int x2, int y2) {
            // 需要旋转的元素个数
            int rotateTimes = x2 - x1;
            for (int k = 0; k < rotateTimes; k++) {
                // 暂存 左上角 元素，留出位置给 左下角
                int temp = matrix[x1][y1+k];
                // 左下角 移到 左上角
                matrix[x1][y1+k] = matrix[x2-k][y1];
                // 右下角 移到 左下角
                matrix[x2-k][y1] = matrix[x2][y2-k];
                // 右上角 移到 右下角
                matrix[x2][y2-k] = matrix[x1+k][y2];
                // 左上角 移到 右上角
                matrix[x1+k][y2] = temp;
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        solutionV2020.rotate(matrix1);
        ArrayUtils.printInt2DArray(matrix1);

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        solutionV2020.rotate(matrix2);
        ArrayUtils.printInt2DArray(matrix2);
    }
}

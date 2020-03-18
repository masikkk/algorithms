package others;

import java.util.Arrays;

/**
 * 顺时针旋转输出数组（快看漫画一面）
 * 输入正整数m，输出一个 m*m 的矩阵，其中包含 1...m^2 的整数，按顺时针方向排列。
 * 1   2   3  4
 *  12 13  14  5 
 * 11 16  15  6
 *  10  9   8  7
 * @author masikkk.com
 * @create 2020-03-18 14:06
 */
public class MMatirx {
    public static int[][] getMMatrix(int m) {
        if (m < 1) {
            return null;
        }
        if (m == 1) {
            int[][] res = new int[1][1];
            res[0][0] = 1;
            return res;
        }

        int res[][] = new int[m][m]; // 结果
        int level = m / 2; // 圈数

        int count = 1; // 当前打印的数字
        for (int k = 0; k <= level; k++) {
            // 把一圈数放入 res
            int minRow = k, maxRow = m - k, minColumn = k, maxColumn = m - k;
            // 上
            for (int i = minRow, j = minColumn; j < maxColumn; j++) {
                res[i][j] = count++;
            }
            // 右
            for (int i = minRow + 1, j = maxColumn - 1; i < maxRow; i++) {
                res[i][j] = count++;
            }
            // 下
            for (int i = maxRow - 1, j = maxColumn - 2; j >= minColumn; j--) {
                res[i][j] = count++;
            }
            // 左
            for (int i = maxRow - 2, j = minColumn; i > minRow; i--) {
                res[i][j] = count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 4;
        int res[][] = getMMatrix(m);
        for (int i = 0; i< m; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        m = 5;
        int res2[][] = getMMatrix(m);
        for (int i = 0; i< m; i++) {
            System.out.println(Arrays.toString(res2[i]));
        }
    }
}

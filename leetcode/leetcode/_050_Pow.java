package leetcode.leetcode;

/**
 * 实现Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @author masikkk.com 2020-05-11 12:47
 */
public class _050_Pow {
    private static class SolutionV2020 {
        public double myPow(double x, int n) {
            // 用 long 型处理 n，避免 -n 溢出
            long nLong = n;
            if (nLong == 0) {
                return 1;
            } else if (nLong < 0) {
                return 1 / pow(x, -nLong);
            } else {
                return pow(x, nLong);
            }
        }

        // 计算 x 的 n 次方， n 是正整数
        private double pow(double x, long n) {
            if (n == 1) {
                return x;
            }
            // 注意避免计算两遍 pow(x, n / 2);
            double temp = pow(x, n / 2);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * x;
            }
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.myPow(2.00000, 10));
        System.out.println(solutionV2020.myPow(2.10000, 3));
        System.out.println(solutionV2020.myPow(2.00000, -2));
        // 易错用例 超时
        System.out.println(solutionV2020.myPow(0.00001, 2147483647));
        // 易错用例，n 是 Integer.MIN_VALUE ， 用 int 表示 -n 会溢出导致错误结果
        System.out.println(solutionV2020.myPow(1.00000, -2147483648));
    }
}
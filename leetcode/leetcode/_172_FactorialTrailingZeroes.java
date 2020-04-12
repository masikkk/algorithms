package leetcode.leetcode;

/**
 * 阶乘后的零
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @author masikkk.com 2020-04-12 22:37
 */
public class _172_FactorialTrailingZeroes {
    private static class SolutionV2020 {
        public int trailingZeroes(int n) {
            // five 必须用 long，否则随着 five 不断增大会溢出 int 导致变为负值，进而多统计
            long five = 5;
            int zeroCount = 0;
            while (five <= n) {
                zeroCount += n / five;
                five *= 5;
            }
            return zeroCount;
        }

        // 改进方法，n 不断除以 5 变小，没有溢出风险
        public int trailingZeroes2(int n) {
            int zeroCount = 0;
            while (n != 0) {
                zeroCount += n / 5;
                n /= 5;
            }
            return zeroCount;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.trailingZeroes(3));
        System.out.println(solutionV2020.trailingZeroes(5));
        System.out.println(solutionV2020.trailingZeroes(11));
        System.out.println(solutionV2020.trailingZeroes(25));
        // 易错用例，正确结果是 452137076， 如果 five 变量用 int 会溢出变为负值导致多统计了2个5得到错误结果 452137078
        System.out.println(solutionV2020.trailingZeroes(1808548329));

        System.out.println(solutionV2020.trailingZeroes2(3));
        System.out.println(solutionV2020.trailingZeroes2(5));
        System.out.println(solutionV2020.trailingZeroes2(11));
        System.out.println(solutionV2020.trailingZeroes2(25));
        System.out.println(solutionV2020.trailingZeroes2(1808548329));
    }
}
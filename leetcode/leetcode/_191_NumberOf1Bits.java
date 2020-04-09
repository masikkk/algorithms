package leetcode.leetcode;

/**
 * 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class _191_NumberOf1Bits {
    private static class SolutionV2018 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            long unsignedn = n & 0xFFFFFFFFL; //用long型表示无符号int
            int result = 0;
            while (unsignedn > 0) {
                result += unsignedn % 2;
                unsignedn = unsignedn / 2;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        //Integer.MAX_VALUE: (2^31)-1, 2147483647
        //Integer.MAX_VALUE+1: -2^31, -2147483648
        System.out.println(solutionV2018.hammingWeight(Integer.MAX_VALUE));//2147483648
    }
}

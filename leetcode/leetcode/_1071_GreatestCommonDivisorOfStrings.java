package leetcode.leetcode;

/**
 * 字符串的最大公因子
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 * @author masikkk.com
 * @create 2020-03-12 19:56
 */
public class _1071_GreatestCommonDivisorOfStrings {
    private static class SolutionV2020 {
        public String gcdOfStrings(String str1, String str2) {
            if (null == str1 || null == str2 || str1.length() == 0 || str2.length() == 0) {
                return "";
            }
            // str1 是较长的
            if (str2.length() > str1.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            // 辗转相除法
            while (str1.indexOf(str2) == 0) {
                String mod = str1.substring(str2.length());
                if (mod.length() == 0) {
                    return str2;
                }
                // str1 是较长的
                if (mod.length() > str2.length()) {
                    str1 = mod;
                } else {
                    str1 = str2;
                    str2 = mod;
                }
            }
            return "";
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(solutionV2020.gcdOfStrings("ABABAB", "AB"));
        System.out.println(solutionV2020.gcdOfStrings("Leet", "Code"));
        System.out.println(solutionV2020.gcdOfStrings("ee", "eeeee"));
    }
}

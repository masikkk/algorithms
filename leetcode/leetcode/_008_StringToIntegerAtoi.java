package leetcode.leetcode;
/**
 * 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @author masikkk.com
 * @create 2020-04-03 10:31
 */
public class _008_StringToIntegerAtoi {
    private static class SolutionV2020 {
        public int myAtoi(String str) {
            if (null == str) {
                return 0;
            }
            // 去掉前后空白
            str = str.trim();
            if (str.length() == 0) {
                return 0;
            }
            char[] chars = str.toCharArray();
            int sign = 1;
            int start = 0;
            // 处理开头的符号位
            if (chars[0] == '-' || chars[0] == '+') {
                start = 1;
                if (chars[0] == '-') {
                    sign = -1;
                }
            } else if (!(chars[0] >= '0' && chars[0] <= '9')) {
                return 0;
            }
            long res = 0;
            for (int i = start; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    long temp = res * 10 + chars[i] - '0';
                    if (temp * sign > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (temp * sign < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    res = (int)temp;
                } else {
                    break;
                }
            }
            return (int)res * sign;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.myAtoi("42"));
        System.out.println(solutionV2020.myAtoi("   -42"));
        System.out.println(solutionV2020.myAtoi("4193 with words"));
        System.out.println(solutionV2020.myAtoi("words and 987"));
        System.out.println(solutionV2020.myAtoi("-91283472332"));
        System.out.println(solutionV2020.myAtoi("3.14159"));
    }
}

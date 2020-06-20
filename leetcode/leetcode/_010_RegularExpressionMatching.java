package leetcode.leetcode;

/**
 * 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * @author masikkk.com 2020-06-20 21:09
 */
public class _010_RegularExpressionMatching {
    private static class SolutionV202006 {
        public boolean isMatch(String s, String p) {
            // dp[i][j] 表示 s 前 i 个字符和 p 前 j 个字符是否匹配，即 s[0...i-1] 和 p[0...j-1] 是否匹配
            // 则 dp[0][0] = true, dp[s.length][p.length] 就是最终结果
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1]; // 默认都是 false
            dp[0][0] = true;

            // 遍历填表
            for (int i = 0; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (j > 0 && p.charAt(j - 1) == '*') {
                        // s[i-1] 和 p[j-2] 匹配时， dp[i][j] = dp[i-1][j](和s前一个字符比较) || dp[i][j-2] (不使用当前的 x* 模式)
                        if (i > 0 && match(s.charAt(i - 1), p.charAt(j - 2))) {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        } else {
                            // s[i-1] 和 p[j-2] 不匹配时，dp[i][j] = dp[i][j-2]，即不使用当前的 x* 模式
                            dp[i][j] = dp[i][j - 2];
                        }
                    } else {
                        if (i > 0 && match(s.charAt(i - 1), p.charAt(j - 1))) {
                            // s[i-1] 和 p[j-1] 匹配时， dp[i][j] = dp[i-1][j-1]；否则 dp[i][j] = false
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }

        // 判断字符 s 和 p 是否匹配
        private boolean match(char s, char p) {
            return p == '.' || p == s;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.isMatch("", "a*"));
        System.out.println(solutionV202006.isMatch("aa", "a"));
        System.out.println(solutionV202006.isMatch("a", "a*"));
        System.out.println(solutionV202006.isMatch("aa", "a*"));
        System.out.println(solutionV202006.isMatch("ab", ".*"));
        System.out.println(solutionV202006.isMatch("aab", "c*a*b"));
        System.out.println(solutionV202006.isMatch("mississippi", "mis*is*p*."));
    }
}
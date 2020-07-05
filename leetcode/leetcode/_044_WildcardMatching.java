package leetcode.leetcode;

/**
 * 通配符匹配
 * https://leetcode-cn.com/problems/wildcard-matching/
 * @author masikkk.com
 * @create: 2020-07-05 17:17
 */
public class _044_WildcardMatching {
    private static class SolutionV202007 {
        public boolean isMatch(String s, String p) {
            // dp[i][j] 表示 s 前 i 个字符组成的子串和 p 前 j 个字符组成的子串是否匹配
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true; // s,p 都是空串时为 true
            // p 为空 s 不为空时是 false，boolean 数组默认值就是 false，无需初始化
            // s 为空 p 不为空时，只有当 p 全是 * 号时才是 true
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }

            // 遍历填表，i,j 遍历的是二维表格 dp 的下标
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) != '*') {
                        // p[j-1] 不是星号时， p[j-1]==s[i-1] 或 p[j-1]=='?' 时， dp[i][j] = dp[i-1][j-1]
                        dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                    } else {
                        // p[j-1] 是星号，可以选择匹配或不匹配当前星号
                        // 不匹配当前星号时，dp[i][j] = dp[i][j-1]，匹配当前星号时 dp[i][j] = dp[i-1][j]
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.isMatch("aa", "a"));
        System.out.println(solutionV202007.isMatch("aa", "*"));
        System.out.println(solutionV202007.isMatch("cb", "?a"));
        System.out.println(solutionV202007.isMatch("adceb", "*a*b"));
        System.out.println(solutionV202007.isMatch("acdcb", "a*c?b"));
    }
}

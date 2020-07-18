package leetcode.leetcode;

/**
 * 交错字符串
 * https://leetcode-cn.com/problems/interleaving-string/
 * @author masikkk.com
 * @create: 2020-07-18 22:53
 */
public class _097_InterleavingString {
    private static class SolutionV202007 {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            // dp[i][j] 表示 s1 前 i 个字符和 s2 前 j 个字符能否构成 s3 前 i+j 个字符
            // 则 dp[i][j] = (s1[i-1] == s3[i+j-1] && dp[i-1][j]) || (s2[j-1] == s3[i+j-1] && dp[i][j-1])
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

            // 遍历填表，i,j 遍历的是 dp 二维数组
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (i - 1 >= 0) {
                        dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                        if (dp[i][j]) {
                            continue;
                        }
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solutionV202007.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}

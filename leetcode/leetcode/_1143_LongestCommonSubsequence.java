package leetcode.leetcode;
/**
 * 最长公共子序列Longest Common Subsequence,LCS
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @author masikkk.com
 * @create 2020-02-22 19:03
 */
public class _1143_LongestCommonSubsequence {
    private static class SolutionV2020 {
        public int longestCommonSubsequence(String text1, String text2) {
            if (null == text1 || text1.length() == 0 || null == text2 || text2.length() == 0) {
                return 0;
            }
            // lcs[i][j] 表示 text1[0...i-1] 和 text2[0...j-1] 的最长公共子序列的长度
            int[][] lcs = new int[text1.length() + 1][text2.length() + 1];
            // lcsStr[i][j] 表示 text1[0...i-1] 和 text2[0...j-1] 的最长公共子序列
            String[][] lcsStr = new String[text1.length() + 1][text2.length() + 1];
            for (int i = 0; i <= text1.length(); i++) {
                for (int j = 0; j <= text2.length(); j++) {
                    if (i == 0 || j == 0) {
                        lcs[i][j] = 0;
                        lcsStr[i][j] = "";
                        continue;
                    }
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        lcs[i][j] = lcs[i - 1][j - 1] + 1;
                        lcsStr[i][j] = lcsStr[i - 1][j - 1] + text1.substring(i - 1, i);
                    } else {
                        lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                        lcsStr[i][j] = lcs[i - 1][j] > lcs[i][j - 1] ? lcsStr[i - 1][j] : lcsStr[i][j - 1];
                    }
                }
            }
            System.out.println(lcsStr[text1.length()][text2.length()]);
            return lcs[text1.length()][text2.length()];
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.longestCommonSubsequence("abcde", "ace"));
        System.out.println(solutionV2020.longestCommonSubsequence("abc", "abc"));
        System.out.println(solutionV2020.longestCommonSubsequence("abc", "def"));
    }
}

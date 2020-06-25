package leetcode.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * @author masikkk.com 2020-06-25 20:45
 */
public class _139_WordBreak {
    private static class SolutionV202006 {
        public boolean wordBreak(String s, List<String> wordDict) {
            // dp[i] 表示 s 中前 i 个字符 s[0...i-1] 组成的子串是否可以拆分为单词，dp[s.length] 就是最终结果
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            Set<String> wordSet = new HashSet<>(wordDict);
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    dp[i] = dp[j] && wordSet.contains(s.substring(j, i));
                    if (dp[i]) {
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(solutionV202006.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solutionV202006.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
package temp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 恢复空格
 * https://leetcode-cn.com/problems/re-space-lcci/
 * @author masikkk.com
 * @create: 2020-07-09 21:02
 */
public class _1713_ReSpace {
    private static class SolutionV202007 {
        public int respace(String[] dictionary, String sentence) {
            Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
            // dp[i] 表示前 i 个字符的最少未识别字符数量
            int[] dp = new int[sentence.length() + 1];

            // 遍历填表，i 遍历的是 dp 下标
            for (int i = 1; i <= sentence.length(); i++) {
                dp[i] = dp[i - 1] + 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (dict.contains(sentence.substring(j, i))) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }
            }
            return dp[sentence.length()];
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.respace(new String[] {"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother"));
    }
}

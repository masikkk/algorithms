package leetcode.leetcode;
/**
 * 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 * @author masikkk.com
 * @create 2020-04-06 17:42
 */
public class _072_EditDistance {
    private static class SolutionV2020 {
        public int minDistance(String word1, String word2) {
            if (null == word1 && null == word2) {
                return 0;
            }
            if (null == word1 || null == word2) {
                return null == word1 ? word2.length() : word1.length();
            }
            if (word1.equals(word2)) {
                return 0;
            }
            // dist[i][j] 表示 word1[0...i-1] 转换为 word2[0...j-1] 的最小操作次数，则
            // word1[i] == word2[j] 时， dist[i][j] = dist[i-1][j-1]
            // word1[i] != word2[j] 时， min(dist[i-1][j]+1, dist[i][j-1]+1, dist[i-1][j-1]+1)
            int[][] dist = new int[word1.length() + 1][word2.length() + 1];

            // word2 为空串
            for (int i = 0; i <= word1.length(); i++) {
                dist[i][0] = i;
            }
            // word1 为空串
            for (int j = 0; j <= word2.length(); j++) {
                dist[0][j] = j;
            }

            for (int i = 0; i < word1.length(); i++) {
                for (int j = 0; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dist[i+1][j+1] = dist[i][j];
                    } else {
                        dist[i+1][j+1] = Math.min(dist[i][j+1], Math.min(dist[i+1][j], dist[i][j])) + 1;
                    }
                }
            }
            return dist[word1.length()][word2.length()];
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.minDistance("horse", "ros"));
        System.out.println(solutionV2020.minDistance("intention", "execution"));
        System.out.println(solutionV2020.minDistance("", ""));
        System.out.println(solutionV2020.minDistance("abc", ""));
        System.out.println(solutionV2020.minDistance("", "abc"));
    }
}

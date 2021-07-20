package temp;

/**
 * 地下城游戏
 * https://leetcode-cn.com/problems/dungeon-game/
 * @author masikkk.com
 * @create: 2020-07-12 22:58
 */
public class _174_DungeonGame {
    private static class SolutionV202007 {
        public int calculateMinimumHP(int[][] dungeon) {
            // dp[i][j] 表示从 dungeon[i][j] 开始所需的最小健康点数，则 dp[0][0] 就是最终结果
            // 则 dp[i][j] = min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j] 且 dp[i][j] 必须大于等于 1
            int m = dungeon.length, n = dungeon[0].length;
            int[][] dp = new int[m][n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j] = Math.max(-dungeon[m - 1][n - 1] + 1, 1);
                        continue;
                    }
                    int down = i + 1 <= m - 1 ? dp[i + 1][j] : Integer.MAX_VALUE;
                    int right = j + 1 <= n - 1 ? dp[i][j + 1] : Integer.MAX_VALUE;
                    dp[i][j] = Math.max(Math.min(down, right) - dungeon[i][j], 1);
                }
            }
            return dp[0][0];
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        System.out.println(solutionV202007.calculateMinimumHP(new int[][] {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }
}

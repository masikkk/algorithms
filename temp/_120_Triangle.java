package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * @author masikkk.com
 * @create: 2020-07-14 21:11
 */
public class _120_Triangle {
    private static class SolutionV202007 {
        public int minimumTotal(List<List<Integer>> triangle) {
            // dp[i][j] 表示从开始到第 i 行第 j 列的最小路径和
            // 则 dp[i][j] = min(dp[i -1][j], dp[i-1][j-1])
            int n = triangle.size();
            int[][] dp = new int[n][n];
            int least = Integer.MAX_VALUE;
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j <= i; j++) {
                    int cur = triangle.get(i).get(j);
                    if (i == 0) {
                        // 第 0 层
                        dp[i][j] = cur;
                    } else {
                        if (j - 1 < 0) {
                            dp[i][j] = dp[i - 1][j] + cur;
                        } else if (j > i - 1) {
                            dp[i][j] = dp[i - 1][j - 1] + cur;
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j - 1] + cur, dp[i - 1][j] + cur);
                        }
                    }
                    // 最后一层再更新 least
                    if (i == n - 1) {
                        least = Math.min(least, dp[i][j]);
                    }
                }
            }
            return least;
        }
    }

    public static void main(String[] args) {
        SolutionV202007 solutionV202007 = new SolutionV202007();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(solutionV202007.minimumTotal(triangle));

        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));
        System.out.println(solutionV202007.minimumTotal(triangle2));
    }
}

package temp;

/**
 * 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author masikkk.com
 * @create: 2020-07-10 20:56
 */
public class _309_BestTimeToBuyAndSellStockWithCooldown {
    private static class SolutionV202007 {
        public int maxProfit(int[] prices) {
            // dp[i] 表示前 i 天的最大收益
            int[] dp = new int[prices.length + 1];

            // 遍历填表
            for (int i = 1; i <= prices.length; i++) {
            }
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}

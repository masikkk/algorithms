package leetcode.leetcode;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author masikkk.com 2020-04-19 18:26
 */
public class _122_BestTimeToBuyAndSellStock2 {
    private static class SolutionV2020 {
        public int maxProfit(int[] prices) {
            if (null == prices || prices.length < 2) {
                return 0;
            }
            int minIndex = 0;
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < prices[i - 1] && prices[i - 1] > prices[minIndex]) {
                    // 价格开始下降，卖出
                    maxProfit += prices[i - 1] - prices[minIndex];
                    minIndex = i;
                    continue;
                }
                minIndex = prices[i] < prices[minIndex] ? i : minIndex;
            }
            // 单独处理最后价格是上升的情况，最后卖出
            if (prices[prices.length - 1] > prices[minIndex]) {
                maxProfit += prices[prices.length - 1] - prices[minIndex];
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(solutionV2020.maxProfit(new int[] {1,2,3,4,5}));
        System.out.println(solutionV2020.maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(solutionV2020.maxProfit(new int[] {2,4,1}));
    }
}
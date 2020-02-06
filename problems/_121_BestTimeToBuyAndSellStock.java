package problems;

import structs.ListNode;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
class _121_BestTimeToBuyAndSellStock {
    private static class SolutionV2018 {
        public int maxProfit(int[] prices) {
            int minIndex = 0, maxindex = prices.length - 1;
            for (int i = 1, j = prices.length - 2; i <= j; i++, j--) {
                if (prices[i] < prices[minIndex] && minIndex < maxindex) {
                    minIndex = i;
                }
                if (prices[j] > prices[maxindex] && minIndex < maxindex) {
                    maxindex = j;
                }
            }
            return prices[maxindex] - prices[minIndex];
        }

        //O(n^2)，超时
        public int maxProfit2(int[] prices) {
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    max = prices[j] - prices[i] > max ? prices[j] - prices[i] : max;
                }
            }
            return max;
        }
    }

    private static class SolutionV2020 {
        public int maxProfit(int[] prices) {
            if (null == prices || prices.length == 0) {
                return 0;
            }
            int min = prices[0];
            // 当前值与最小值差值的最大值
            int maxDiff = 0;

            for (int n : prices) {
                min = Math.min(min, n);
                maxDiff = Math.max(maxDiff, n - min);
            }
            return maxDiff;
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.maxProfit(ListNode.stringToIntegerArray("[7,1,5,3,6,4]")));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.maxProfit(ListNode.stringToIntegerArray("[7,1,5,3,6,4]")));
        System.out.println(solutionV2020.maxProfit(ListNode.stringToIntegerArray("[7,6,4,3,1]")));
    }
}

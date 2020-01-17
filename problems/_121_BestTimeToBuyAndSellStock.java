
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

    public static void main(String[] args) {
        SolutionV2018 solution = new SolutionV2018();
        int[] prices = {2, 7, 1, 3};
        System.out.println(solution.maxProfit(prices));
    }
}

package leetcode.leetcode;

/**
 * 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * @author masikkk.com 2020-05-06 15:57
 */
public class _983_MinimumCostForTickets {
    private static class SolutionV2020 {
        public int mincostTickets(int[] days, int[] costs) {
            // dp[i] 表示能完成从第 days[i] 天开始到结束的最小花费
            int[] dp = new int[days.length + 1]; // 全初始化为0
            // 从后往前考虑
            for (int i = days.length - 1; i >= 0; i--) {
                // 在第 days[i] 天购买 1日、7日、30日票的花费，取其中最小的
                // 购买 1 日票只能管今天，总花费要加上从第 days[i] + 1 天开始的后续花费
                int buy1DayCost = costs[0] + dp[i + 1];
                // 购买 7 日票能管从第 days[i] 天到 days[i] + 6 天，总花费要加上从第 days[i] + 7 天开始的后续花费
                int buy7DayCost = costs[1] + dp[findLeastIndexAfterN(days, i, days[i] + 7)];
                // 购买 30 日票能管从第 days[i] 天到 days[i] + 29 天，总花费要加上从第 days[i] + 30 天开始的后续花费
                int buy30DayCost = costs[2] + dp[findLeastIndexAfterN(days, i, days[i] + 30)];
                dp[i] = Math.min(buy1DayCost, Math.min(buy7DayCost, buy30DayCost));
            }
            return dp[0];
        }

        // 找到 days[] 数组中 i 之后第一个大于等于 target 的元素的下标，这个方法复杂度为常数 O(1)，因为下标 j 最多移动 30 步
        private int findLeastIndexAfterN(int[] days, int i, int target) {
            int j = i;
            while (j < days.length && days[j] < target) {
                j++;
            }
            return j;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.mincostTickets(new int[] {1,4,6,7,8,20}, new int[] {2,7,15}));
        System.out.println(solutionV2020.mincostTickets(new int[] {1,2,3,4,5,6,7,8,9,10,30,31}, new int[] {2,7,15}));
    }
}
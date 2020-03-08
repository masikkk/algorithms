package problems;

import structs.ListNode;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * @author masikkk.com
 * @create 2020-03-08 16:21
 */
public class _322_CoinChange {
    private static class SolutionV2020 {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                int min = -1;
                for (int coin : coins) {
                    if (i == coin) {
                        // 当前硬币就是要找的金额
                        min = 1;
                        break;
                    } else if (i > coin) {
                        if (dp[i - coin] == -1) {
                            // 找不开
                            continue;
                        }
                        min = (-1 == min ? dp[i - coin] + 1 : Math.min(min, dp[i - coin] + 1));
                    }
                }
                dp[i] = min;
            }
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.coinChange(ListNode.stringToIntegerArray("[1,2,5]"), 11));
        System.out.println(solutionV2020.coinChange(ListNode.stringToIntegerArray("[2]"), 3));
        System.out.println(solutionV2020.coinChange(ListNode.stringToIntegerArray("[186,419,83,408]"), 6249));
    }
}

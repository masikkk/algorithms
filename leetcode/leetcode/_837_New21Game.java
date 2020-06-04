package leetcode.leetcode;

/**
 * 新21点
 * https://leetcode-cn.com/problems/new-21-game/
 * @author masikkk.com 2020-06-03 18:35
 */
public class _837_New21Game {
    private static class SolutionV202006 {
        public double new21Game(int n, int k, int w) {
            // dp[i] 表示手里累积的点数是 i 时继续游戏直到结束的胜率（即停止抽牌后点数小于等于n的概率）
            double[] dp = new double[k + w];
            // dp 数组的后缀和数组，长度比原数组多1，方便直接累加最后一个元素
            double[] suffixSum = new double[k + w + 1];

            for (int i = dp.length - 1; i >= 0; i--) {
                if (i >= k) {
                    // 当前累积点数大于等于 k 时无法再抽牌，直接根据手中的点数可计算胜率，小于等于 n 则胜率为1，大于 n 则胜率为 0
                    dp[i] = (i <= n ? 1 : 0);
                } else {
                    // 当前累积点数小于 k 时可继续抽牌，抽到的牌面可能是 1 到 w 中任意一张，概率都是 1/w，所以胜率是后面 w 种可能的概率的平均值
                    dp[i] = (suffixSum[i+1] - suffixSum[i + w + 1]) / w;
                }
                suffixSum[i] = suffixSum[i+1] + dp[i];
            }
            return dp[0];
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.new21Game(10, 1, 10));
        System.out.println(solutionV202006.new21Game(6, 1, 10));
        System.out.println(solutionV202006.new21Game(21, 17, 10));
    }
}
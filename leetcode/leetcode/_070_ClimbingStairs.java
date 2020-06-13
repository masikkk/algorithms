package leetcode.leetcode;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author masikkk.com 2020-06-13 22:49
 */
public class _070_ClimbingStairs {
    private static class SolutionV202006 {
        public int climbStairs(int n) {
            // dp[i] 表示爬 n 阶台阶的方法数，则 dp[i] = dp[i-1] + dp[i-2]， dp[0] = 1, dp[1] = 1
            int prePre = 1;
            int pre = 1;
            for (int i = 2; i <= n; i++) {
                int newPre = prePre + pre;
                prePre = pre;
                pre = newPre;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.climbStairs(2));
        System.out.println(solutionV202006.climbStairs(3));
    }
}
package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 * @author si.ma
 * @create 2020-04-11 16:58
 */
public class _887_SuperEggDrop {
    // 超时方法改进，二分搜索
    private static class SolutionV2020BinarySearch {
        public int superEggDrop(int k, int n) {
            if (k == 1) {
                return n;
            }
            if (n == 1) {
                return 1;
            }
            // dp[i][j] 表示有 i 个鸡蛋 j 层楼时最坏情况下的最小尝试次数
            // 则有 dp[i][j] = min{max{dp[i-1][x-1]}, dp[i][j-x], x = 1,...,j} + 1
            int[][] dp = new int[k + 1][n + 1]; // 默认全为0

            // 楼层数为1时，无论有多少个鸡蛋最小尝试次数肯定是1
            for (int i = 1; i <= k; i++) {
                dp[i][1] = 1;
            }

            // 鸡蛋数是1时，有多少层楼最小尝试次数就是多少
            for (int j = 1; j <= n; j++) {
                dp[1][j] = j;
            }

            // 遍历填表
            for (int i = 2; i <= k; i++) {
                for (int j = 2; j <= n; j++) {
                    // dp[i-1][x-1] 是 x 的单调递增函数， dp[i][j-x] 是 x 的单调递减函数，所以一定是在交点处 max{dp[i-1][x-1]}, dp[i][j-x], x = 1,...,j} 最小
                    // 使用二分搜索优化 x=1,...j 的遍历
                    int low = 1, high = j;
                    while (low < high) {
                        if (low + 1 == high) {
                            break;
                        }
                        int mid = (low + high) / 2;
                        if (dp[i-1][mid-1] > dp[i][j-mid]) {
                            high = mid - 1;
                        } else {
                            low = mid;
                        }
                    }
                    int maxX = Math.max(dp[i-1][low-1], dp[i][j-low]);
                    int maxX1 = Math.max(dp[i-1][low], dp[i][j-low-1]);
                    int min = Math.min(maxX, maxX1);
                    dp[i][j] = min + 1;
                }
            }
            return dp[k][n];
        }
    }

    @Test
    public void testSolutionV2020BinarySearch() {
        SolutionV2020BinarySearch solutionV2020BinarySearch = new SolutionV2020BinarySearch();
        System.out.println(solutionV2020BinarySearch.superEggDrop(1, 2));
        System.out.println(solutionV2020BinarySearch.superEggDrop(2, 6));
        System.out.println(solutionV2020BinarySearch.superEggDrop(3, 14));
        System.out.println(solutionV2020BinarySearch.superEggDrop(2, 100));
        // 超时用例
        System.out.println(solutionV2020BinarySearch.superEggDrop(8, 10000));
    }

    // 超时， 84 / 121 个通过测试用例
    private static class SolutionV2020TimeExceed {
        public int superEggDrop(int k, int n) {
            if (k == 1) {
                return n;
            }
            if (n == 1) {
                return 1;
            }
            // dp[i][j] 表示有 i 个鸡蛋 j 层楼时最坏情况下的最小尝试次数
            // 则有 dp[i][j] = min{max{dp[i-1][x-1]}, dp[i][j-x], x = 1,...,j} + 1
            int[][] dp = new int[k + 1][n + 1]; // 默认全为0

            // 楼层数为1时，无论有多少个鸡蛋最小尝试次数肯定是1
            for (int i = 1; i <= k; i++) {
                dp[i][1] = 1;
            }

            // 鸡蛋数是1时，有多少层楼最小尝试次数就是多少
            for (int j = 1; j <= n; j++) {
                dp[1][j] = j;
            }

            // 遍历填表
            for (int i = 2; i <= k; i++) {
                for (int j = 2; j <= n; j++) {
                    int min = Integer.MAX_VALUE;
                    for (int x = 1; x <= j; x++) {
                        min = Math.min(min, Math.max(dp[i-1][x-1], dp[i][j-x]));
                    }
                    dp[i][j] = min + 1;
                }
            }
            return dp[k][n];
        }
    }

    @Test
    public void testSolutionV2020TimeExceed() {
        SolutionV2020TimeExceed solutionV2020TimeExceed = new SolutionV2020TimeExceed();
        System.out.println(solutionV2020TimeExceed.superEggDrop(1, 2));
        System.out.println(solutionV2020TimeExceed.superEggDrop(2, 6));
        System.out.println(solutionV2020TimeExceed.superEggDrop(3, 14));
        System.out.println(solutionV2020TimeExceed.superEggDrop(2, 100));
        // 超时用例
        System.out.println(solutionV2020TimeExceed.superEggDrop(8, 10000));
    }
}

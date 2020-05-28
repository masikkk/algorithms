package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * 和可被 K 整除的子数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * @author masikkk.com 2020-05-27 17:48
 */
public class _974_SubarraySumsDivisibleByK {
    // 哈希表存储前缀和，超时，68 / 73 个通过测试用例
    private static class SolutionV202005PreSumBrutal {
        public int subarraysDivByK(int[] nums, int k) {
            if (null == nums || nums.length < 1) {
                return 0;
            }
            Map<Integer, Integer> preSumToCountMap = new HashMap<>();
            // 前缀和为 0 的子数组个数为1，目的是为了统计从开头到 i 的子数组 nums[0...i] 的信息时依然正确
            preSumToCountMap.put(0, 1);

            int res = 0;
            int preSum = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                // 统计以当前元素为结尾的子数组中和是 k 的倍数的子树组个数
                for(Map.Entry<Integer, Integer> entry : preSumToCountMap.entrySet()) {
                    if ((preSum - entry.getKey()) % k == 0) {
                        res += entry.getValue();
                    }
                }
                preSumToCountMap.put(preSum, preSumToCountMap.getOrDefault(preSum, 0) + 1);
            }
            return res;
        }
    }

    @Test
    public void testSolutionV202005PreSumBrutal() {
        SolutionV202005PreSumBrutal solutionV202005PreSumBrutal = new SolutionV202005PreSumBrutal();
        System.out.println(solutionV202005PreSumBrutal.subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5));
        System.out.println(solutionV202005PreSumBrutal.subarraysDivByK(new int[] {4}, 2));
        System.out.println(solutionV202005PreSumBrutal.subarraysDivByK(new int[] {0,-5}, 10));
    }

    // 哈希表存储前缀和mod K后的出现次数
    private static class SolutionV202005PreSumModK {
        public int subarraysDivByK(int[] nums, int k) {
            if (null == nums || nums.length < 1) {
                return 0;
            }
            // 前缀和 mod k 后的出现次数
            Map<Integer, Integer> preSumModKToCountMap = new HashMap<>();
            // 前缀和为 0 的子数组个数为1，目的是为了统计从开头到 i 的子数组 nums[0...i] 的信息时依然正确
            preSumModKToCountMap.put(0, 1);

            int res = 0;
            int preSum = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                // 模
                int mod = Math.floorMod(preSum, k);
                // 统计以当前元素为结尾的子数组中和是 k 的倍数的子树组个数
                res += preSumModKToCountMap.getOrDefault(mod, 0);
                preSumModKToCountMap.put(mod, preSumModKToCountMap.getOrDefault(mod, 0) + 1);
            }
            return res;
        }
    }

    @Test
    public void testtestSolutionV202005PreSumBrutal() {
        SolutionV202005PreSumModK solutionV202005PreSumModK = new SolutionV202005PreSumModK();
        System.out.println(solutionV202005PreSumModK.subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5));
        System.out.println(solutionV202005PreSumModK.subarraysDivByK(new int[] {4}, 2));
        System.out.println(solutionV202005PreSumModK.subarraysDivByK(new int[] {0,-5}, 10));
        System.out.println(solutionV202005PreSumModK.subarraysDivByK(new int[] {-1,2,9}, 2));
        System.out.println(solutionV202005PreSumModK.subarraysDivByK(new int[] {2,-2,2,-4}, 6));
    }
}
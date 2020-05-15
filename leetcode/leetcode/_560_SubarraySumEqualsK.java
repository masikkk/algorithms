package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @author masikkk.com 2020-05-15 17:25
 */
public class _560_SubarraySumEqualsK {
    private static class SolutionV202005 {
        public int subarraySum(int[] nums, int k) {
            if (null == nums || nums.length < 1) {
                return 0;
            }
            // 前缀和 -> 有多少个具有此前缀和的子数组
            Map<Long, Integer> preSumToCountMap = new HashMap<>();
            // 暗藏一个前缀和为 0 的子数组
            preSumToCountMap.put(0L, 1);
            int count = 0;
            // 前缀和
            long preSum = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                // 0... i-1 中有多少个具有前缀和 preSum-k 的子数组，则就有多少个以 i 为结尾的和为 k 的连续子数组
                count += preSumToCountMap.getOrDefault(preSum - k, 0);
                preSumToCountMap.put(preSum, preSumToCountMap.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }
    }

    @Test
    public void testSolutionV202005() {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.subarraySum(new int[] {1,1,1}, 2));
        System.out.println(solutionV202005.subarraySum(new int[] {1,2,1,2,3,-1,3,2}, 3));
    }
}
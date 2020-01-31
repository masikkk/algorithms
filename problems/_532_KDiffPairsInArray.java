package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中的k-diff数对
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/
 * @author masikkk.com
 * @create 2020-01-30 17:35
 */
public class _532_KDiffPairsInArray {
    private static class SolutionV2020 {
        public int findPairs(int[] nums, int k) {
            if (k < 0) {
                return 0;
            }
            int count = 0;
            // value -> 是否使用过
            Map<Integer, Boolean> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (0 != k) {
                    // 不重复处理元素
                    if (!map.containsKey(nums[i])) {
                        map.put(nums[i], false);
                        if (map.containsKey(nums[i] + k)) {
                            count++;
                        }
                        if (map.containsKey(nums[i] - k)) {
                            count++;
                        }
                    }
                } else {
                    if (!map.containsKey(nums[i])) {
                        map.put(nums[i], false);
                    } else {
                        if (false == map.get(nums[i])) {
                            count ++;
                            map.put(nums[i], true);
                        }
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[] nums = {3, 1, 4, 1, 5};
        int[] nums2 = {1, 2, 3, 4, 5};
        int[] nums3 = {1, 3, 1, 5, 4};
        System.out.println(solutionV2020.findPairs(nums, 2));
        System.out.println(solutionV2020.findPairs(nums2, 1));
        System.out.println(solutionV2020.findPairs(nums3, 0));
        // 易错用例，k为负数时结果永远是0
        System.out.println(solutionV2020.findPairs(nums2, -1));
    }
}

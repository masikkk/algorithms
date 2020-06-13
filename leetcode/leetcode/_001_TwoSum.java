package leetcode.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author masikkk.com 2020-02-02 16:54
 */
public class _001_TwoSum {
    private static class SolutionV2018 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (map.get(target - nums[i]) != null) {
                    result[0] = map.get(target - nums[i]);
                    result[1] = i;
                    break;
                }
                map.put(nums[i], i);//必须先判断再put
            }
            return result;
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(Arrays.toString(solutionV2018.twoSum(new int[]{2, 7, 2, 15}, 4)));
    }
}

package problems;

import java.util.HashMap;
import java.util.Map;

public class _001_TwoSum {
    private static class Solution {
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
        int[] input = {2, 7, 2, 15};
        Solution solution = new Solution();
        int[] output = solution.twoSum(input, 4);
		for (int i : output) {
			System.out.print(i + ",");
		}
    }
}

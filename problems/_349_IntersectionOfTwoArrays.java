package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _349_IntersectionOfTwoArrays {
    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i : nums1) {
                map.put(i, 1);
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int i : nums2) {
                if (map.get(i) != null && map.get(i) == 1) {
                    list.add(i);
                    map.put(i, 2);
                }
            }
            int[] resultInt = list.stream().mapToInt(Integer::intValue).toArray();
            return resultInt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {};
        int[] nums2 = {1, 2};
        int[] result = solution.intersection(nums1, nums2);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }
}

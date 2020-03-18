package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import structs.ListNode;

/**
 * 两数组的交集2
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @author masikkk.com
 * @create 2020-02-08 16:50
 */
public class _350_IntersectionOfTwoArrays2 {
    private static class SolutionV2020 {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (null == nums1 || null == nums2) {
                return null;
            }
            // 数n -> 出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums1) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            List<Integer> resList = new ArrayList<>();
            for (int n : nums2) {
                if (map.containsKey(n)) {
                    int v = map.get(n);
                    if (v > 0) {
                        resList.add(n);
                        map.put(n, v - 1);
                    }
                }
            }
            return resList.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out .println(Arrays.toString(solutionV2020.intersect(
                ListNode.stringToIntegerArray("[1,2,2,1"),
                ListNode.stringToIntegerArray("[2,2]"))));
        System.out .println(Arrays.toString(solutionV2020.intersect(
                ListNode.stringToIntegerArray("[4,9,5"),
                ListNode.stringToIntegerArray("[9,4,9,8,4]"))));
    }
}

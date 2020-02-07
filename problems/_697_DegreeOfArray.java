package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import structs.ListNode;

/**
 * 度数相同的最小连续子数组
 * https://leetcode-cn.com/problems/degree-of-an-array/
 * @author masikkk.com
 * @create 2020-02-07 13:00
 */
public class _697_DegreeOfArray {
    private static class SolutionV2020 {
        public int findShortestSubArray(int[] nums) {
            if (null == nums || nums.length == 0) {
                return 0;
            }
            // 数组元素n -> 出现次数, 第一次出现的index, 最后一次出现的index
            Map<Integer, List<Integer>> map = new HashMap<>();
            // 第一次遍历，统计数组中每个元素的出现次数和首尾距离
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    List<Integer> list = map.get(nums[i]);
                    list.set(0, list.get(0) + 1);
                    if (list.size() == 2) {
                        list.add(i);
                    } else {
                        list.set(2, i);
                    }
                } else {
                    List<Integer> list = new ArrayList(3);
                    list.add(1);
                    list.add(i);
                    map.put(nums[i], list);
                }
            }
            int maxTimes = 0;
            int minLength = 0;
            // 遍历统计结果，找出现次数最多的元素的首尾距离
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                if (list.get(0) > maxTimes) {
                    maxTimes = list.get(0);
                    minLength = list.size() == 3 ? list.get(2) - list.get(1) + 1 : 1;
                } else if (list.get(0) == maxTimes) {
                    // 出现次数一样多的，找首尾距离最短的
                    int thisLength = list.size() == 3 ? list.get(2) - list.get(1) + 1 : 1;
                    minLength = Math.min(thisLength, minLength);
                }
            }
            return minLength;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findShortestSubArray(ListNode.stringToIntegerArray("[1, 2, 2, 3, 1]")));
        System.out.println(solutionV2020.findShortestSubArray(ListNode.stringToIntegerArray("[1,2,2,3,1,4,2]")));
    }
}

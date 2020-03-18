package leetcode.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import javafx.util.Pair;
import structs.ListNode;

/**
 * 前K个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author masikkk.com
 * @create 2020-02-24 12:40
 */
public class _347_TopKFrequentElements {
    private static class SolutionV2020 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            if (null == nums || 0 == nums.length) {
                return null;
            }
            // 统计数组中各个元素的出现次数  数值 -> 次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            // 最小堆，Pair<出现次数, 数值>
//            PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, (p1, p2) -> p1.getKey() - p2.getKey());
            PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(Pair::getKey));
            map.forEach((key, value) -> {
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(new Pair(value, key));
                } else if (value > priorityQueue.peek().getKey()) {
                    priorityQueue.poll();
                    priorityQueue.offer(new Pair(value, key));
                }
            });
            return priorityQueue.stream().map(Pair::getValue).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.topKFrequent(ListNode.stringToIntegerArray("[1,1,1,2,2,3]"), 2));
        System.out.println(solutionV2020.topKFrequent(ListNode.stringToIntegerArray("[1]"), 1));
    }
}

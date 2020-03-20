package leetcode.offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 《剑指offer》面试题40 数组中最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @author masikkk.com
 * @create 2020-03-20 16:58
 */
public class _040_KSmallElements {
    private static class SolutionV2020 {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (0 == k) {
                return new int[] {};
            }
            // 最大堆
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> n2 - n1);

            for (int i = 0; i < arr.length; i++) {
                if (i < k) {
                    priorityQueue.offer(arr[i]);
                } else if (arr[i] < priorityQueue.peek()) {
                    priorityQueue.offer(arr[i]);
                    priorityQueue.poll();
                }
            }

            return priorityQueue.stream().mapToInt(a -> a).toArray();
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(solutionV2020.getLeastNumbers(new int[]{3, 2, 1}, 2)));
        System.out.println(Arrays.toString(solutionV2020.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)));
        System.out.println(Arrays.toString(solutionV2020.getLeastNumbers(new int[]{0, 1, 2, 1}, 0)));
    }
}

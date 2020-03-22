package leetcode.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import structs.ListNode;

/**
 * 使数组唯一的最小增量
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * @author masikkk.com
 * @create 2020-03-22 14:42
 */
public class _945_MinimumIncrementToMakeArrayUnique {
    private static class SolutionV2020 {
        public int minIncrementForUnique(int[] A) {
            if (null == A || A.length < 2) {
                return 0;
            }
            // 快速排序 nlogn
            Arrays.sort(A);
            // 重复个数
            int duplicateCount = 0;
            // 重复数的和，遇到重复数增加其负值，遇到可用的空位增加正值
            int duplicateSum = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1] + 1 && duplicateCount != 0) {
                    // A[i-1] 到 A[i] 之间有 A[i] - A[i-1] - 1 个空位可供使用
                    int emptyCount = Math.min(duplicateCount, A[i] - A[i-1] - 1);
                    duplicateCount -= emptyCount;
                    duplicateSum += emptyCount * (A[i-1] +1) + emptyCount * (emptyCount-1) / 2;
                } else if (A[i] == A[i-1]) {
                    duplicateCount++;
                    duplicateSum += -A[i];
                }
            }
            // 最后可能有还没处理的重复数
            if (duplicateCount != 0) {
                duplicateSum += duplicateCount * (A[A.length-1] + 1) + duplicateCount * (duplicateCount - 1) / 2;
            }
            return duplicateSum;
        }

        // 暴力，超时
        public int minIncrementForUnique_TimeLimitExceed(int[] A) {
            if (null == A || A.length < 2) {
                return 0;
            }

            Map<Integer, Integer> map = new HashMap<>();

            int steps = 0;
            for (int n : A) {
                if (!map.containsKey(n)) {
                    map.put(n, 0);
                } else {
                    int incr = n + 1;
                    while (map.containsKey(incr)) {
                        incr++;
                    }
                    steps += incr - n;
                    map.put(incr, 0);
                }
            }
            return steps;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.minIncrementForUnique(ListNode.stringToIntegerArray("[1,2,2]")));
        System.out.println(solutionV2020.minIncrementForUnique(ListNode.stringToIntegerArray("[3,2,1,2,1,7]")));
    }
}

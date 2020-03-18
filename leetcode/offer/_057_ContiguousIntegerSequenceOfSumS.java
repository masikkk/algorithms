package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 《剑指offer》面试题57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @author masikkk.com
 * @create 2020-03-06 13:27
 */
public class _057_ContiguousIntegerSequenceOfSumS {
    private static class SolutionV2020 {
        public int[][] findContinuousSequence(int sn) {
            LinkedList<List<Integer>> listList = new LinkedList<>();
            // n: 等差序列的个数，从2开始往上找
            for (int n = 2; ; n++) {
                // 等差数列求和公式 sn = na1 + dn(n-1)/2，已知公差d=1，则有 sn = na1 + n(n-1)/2，已知sn，每次循环时的n，直接可得到a1
                int na1 = sn - n * (n-1) / 2;
                // 结束循环
                if (na1 <= 0) {
                    break;
                }
                // 无法整除n，跳过
                if ((na1 % n) != 0) {
                    continue;
                }
                int a1 = na1 / n;
                List<Integer> seqList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    seqList.add(a1++);
                }
                listList.addFirst(seqList);
            }
            int[][] ret = new int[listList.size()][];
            int count = 0; // 序列个数
            for (List<Integer> seq : listList) {
                ret[count++] = seq.stream().mapToInt(Integer::intValue).toArray();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        int[][] ret = solutionV2020.findContinuousSequence(9);
        for (int[] seq : ret) {
            System.out.println(Arrays.toString(seq));
        }
        int[][] ret2 = solutionV2020.findContinuousSequence(15);
        for (int[] seq : ret2) {
            System.out.println(Arrays.toString(seq));
        }
    }
}

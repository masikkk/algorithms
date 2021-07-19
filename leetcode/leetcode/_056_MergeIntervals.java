package leetcode.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.util.Pair;
import utils.ArrayUtils;

/**
 * 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * @author masikkk.com 2020-04-16 11:53
 */
public class _056_MergeIntervals {
    private static class SolutionV2020 {
        public int[][] merge(int[][] intervals) {
            if (null == intervals || intervals.length < 2) {
                return intervals;
            }
//            Arrays.sort(intervals, (v1, v2) -> v1[0]); // 可直接对数组排序
            List<Pair<Integer, Integer>> intervalList = new ArrayList<>();
            for (int[] interval : intervals) {
                intervalList.add(new Pair<>(interval[0], interval[1]));
            }
            // 按左端点排序
            Collections.sort(intervalList, (pair1, pair2) -> pair1.getKey() - pair2.getKey());

            List<Pair<Integer, Integer>> resList = new ArrayList<>();
            Pair<Integer, Integer> curInterval = intervalList.get(0);
            for (int i = 1; i < intervalList.size(); i++) {
                if (isIntersect(intervalList.get(i), curInterval)) {
                    curInterval = mergeTwoInterval(intervalList.get(i), curInterval);
                } else {
                    resList.add(curInterval);
                    curInterval = intervalList.get(i);
                }
            }
            resList.add(curInterval);

            int[][] res = new int[resList.size()][2];
            for (int i = 0; i < resList.size(); i++) {
                int[] inter = new int[2];
                inter[0] = resList.get(i).getKey();
                inter[1] = resList.get(i).getValue();
                res[i] = inter;
            }

            return res;
        }

        // 判断两个区间是否有交点
        private boolean isIntersect(Pair<Integer, Integer> pair1, Pair<Integer, Integer> pair2) {
            return Math.max(pair1.getKey(), pair2.getKey()) <= Math.min(pair1.getValue(), pair2.getValue());
        }

        // 合并两个区间
        private Pair<Integer, Integer> mergeTwoInterval(Pair<Integer, Integer> pair1, Pair<Integer, Integer> pair2) {
            return new Pair<>(Math.min(pair1.getKey(), pair2.getKey()), Math.max(pair1.getValue(), pair2.getValue()));
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        ArrayUtils.printInt2DArray(solutionV2020.merge(new int[][] {{4,5}, {1,4}}));
        ArrayUtils.printInt2DArray(solutionV2020.merge(new int[][] {{1,3}, {2,6}, {8,10}, {15,18}}));
    }
}
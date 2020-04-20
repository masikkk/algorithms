package leetcode.leetcode;

import java.util.Arrays;
import structs.ArrayUtils;

/**
 * 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author masikkk.com 2020-04-20 15:08
 */
public class _452_MinimumNumberOfArrowsToBurstBalloons {
    private static class SolutionV2020 {
        public int findMinArrowShots(int[][] points) {
            if (null == points || 0 == points.length) {
                return 0;
            }
            Arrays.sort(points, (point1, point2) -> point1[0] - point2[0]);
            int minArrows = 0;
            int[] current = points[0];
            for (int i = 1; i < points.length; i++) {
                if (isIntersect(current, points[i])) {
                    current = intersect(current, points[i]);
                } else {
                    minArrows++;
                    current = points[i];
                }
            }
            // 特殊处理最后一个线段
            minArrows = isIntersect(current, points[points.length - 1]) ? minArrows + 1 : minArrows + 2;
            return minArrows;
        }

        // 判断线段 segment1 和 segment2 是否相交
        private boolean isIntersect(int[] segment1, int[] segment2) {
            return Math.max(segment1[0], segment2[0]) <= Math.min(segment1[1], segment2[1]);
        }

        // segment1 和 segment2 的交集(已知相交的前提下)
        private int[] intersect(int[] segment1, int[] segment2) {
            return new int[] {Math.max(segment1[0], segment2[0]), Math.min(segment1[1], segment2[1])};
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findMinArrowShots(ArrayUtils.stringToInt2DArray("[[10,16], [2,8], [1,6], [7,12]]")));
        System.out.println(solutionV2020.findMinArrowShots(ArrayUtils.stringToInt2DArray("[[1,2],[3,4],[5,6],[7,8]]")));
    }
}
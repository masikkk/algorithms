package leetcode.leetcode;

import java.util.Arrays;

/**
 * 分糖果 II
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 * @author masikkk.com
 * @create 2020-03-05 11:37
 */
public class _1103_DistributeCandiesToPeople {
    private static class SolutionV2020 {
        public int[] distributeCandies(int candies, int numPeople) {
            if (candies <= 0 || numPeople <= 0) {
                return null;
            }
            int[] ret = new int[numPeople];
            int i = 0;
            while (candies >= 0) {
                ret[i % numPeople] += Math.min(i + 1, candies);
                i++;
                candies -= i;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(Arrays.toString(solutionV2020.distributeCandies(7, 4)));
        System.out.println(Arrays.toString(solutionV2020.distributeCandies(10, 3)));
        System.out.println(Arrays.toString(solutionV2020.distributeCandies(1000000000, 3)));
        System.out.println(Arrays.toString(solutionV2020.distributeCandies(1, 3)));
    }
}

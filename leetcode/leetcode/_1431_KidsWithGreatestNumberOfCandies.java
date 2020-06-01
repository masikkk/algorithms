package leetcode.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 拥有最多糖果的孩子
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * @author masikkk.com 2020-06-01 21:52
 */
public class _1431_KidsWithGreatestNumberOfCandies {
    private static class SolutionV202006 {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = Arrays.stream(candies).boxed().max(Comparator.comparingInt(Integer::intValue)).get();
            return Arrays.stream(candies).boxed().map(i -> i + extraCandies >= max).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.kidsWithCandies(new int[] {2,3,5,1,3}, 3));
        System.out.println(solutionV202006.kidsWithCandies(new int[] {4,2,1,1,2}, 1));
        System.out.println(solutionV202006.kidsWithCandies(new int[] {12,1,12}, 10));
    }
}
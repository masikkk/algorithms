package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 * @author masikkk.com 2020-05-09 18:36
 */
public class _069_Sqrtx {
    // 直接用库函数
    private static class SolutionV2020Library {
        public int mySqrt(int x) {
            return (int)Math.sqrt(x);
        }
    }

    @Test
    public void testSolutionV2020Library() {
        SolutionV2020Library solutionV2020Library = new SolutionV2020Library();
        System.out.println(solutionV2020Library.mySqrt(4));
        System.out.println(solutionV2020Library.mySqrt(8));
    }

    // 二分搜索
    private static class SolutionV2020BinarySearch {
        public int mySqrt(int x) {
            int low = 0, high = x;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (Math.pow(mid, 2) == x) {
                    return mid;
                } else if (Math.pow(mid + 1, 2) == x) {
                    return mid + 1;
                } else if (Math.pow(mid, 2) < x && Math.pow(mid + 1, 2) > x) {
                    return mid;
                } else if (Math.pow(mid, 2) < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return 0;
        }
    }

    @Test
    public void testSolutionV2020BinarySearch() {
        SolutionV2020BinarySearch solutionV2020BinarySearch = new SolutionV2020BinarySearch();
        System.out.println(solutionV2020BinarySearch.mySqrt(0));
        System.out.println(solutionV2020BinarySearch.mySqrt(1));
        System.out.println(solutionV2020BinarySearch.mySqrt(4));
        System.out.println(solutionV2020BinarySearch.mySqrt(8));
    }
}
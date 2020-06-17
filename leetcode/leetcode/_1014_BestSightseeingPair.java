package leetcode.leetcode;

/**
 * 最佳观光组合
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 * @author masikkk.com 2020-06-17 17:48
 */
public class _1014_BestSightseeingPair {
    private static class SolutionV202006 {
        public int maxScoreSightseeingPair(int[] A) {
            if (null == A || A.length < 2) {
                return 0;
            }
            int maxIndexPlusValue = A[0]; // A[i] + i 的最大值
            int maxScore = 0;
            for (int i = 1; i < A.length; i++) {
                maxScore = Math.max(maxScore, A[i] - i + maxIndexPlusValue);
                maxIndexPlusValue = Math.max(maxIndexPlusValue, i + A[i]);
            }
            return maxScore;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.maxScoreSightseeingPair(new int[] {8,1,5,2,6}));
    }
}
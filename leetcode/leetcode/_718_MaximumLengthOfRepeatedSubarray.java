package leetcode.leetcode;

import structs.ListNode;

/**
 * 最长重复子数组/最长公共子串Longest Common Substring,LCS
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * @author masikkk.com
 * @create 2020-02-22 21:21
 */
public class _718_MaximumLengthOfRepeatedSubarray {
    private static class SolutionV2020 {
        public int findLength(int[] A, int[] B) {
            if (null == A || A.length == 0 || null == B || B.length == 0) {
               return 0;
            }
            // lcs[i][j] 表示 text1[0...i-1] 和 text2[0...j-1] 的以 text1[i-1],text2[j-1] 为结尾(必须包含)的最长公共子串的长度
            int[][] lcs = new int[A.length + 1][B.length + 1];
            // lcsStr[i][j] 表示 text1[0...i-1] 和 text2[0...j-1] 的以 text1[i-1],text2[j-1] 为结尾(必须包含)的最长公共子串
            String[][] lcsStr = new String[A.length + 1][B.length + 1];
            // A,B的最长公共子串长度
            int lcsMax = 0;
            // A,B的最长公共子串
            String lcsStrMax = "";

            for (int i = 0; i <= A.length; i++) {
                for (int j = 0; j <= B.length; j++) {
                    if (i ==0 || j== 0) {
                        lcs[i][j] = 0;
                        lcsStr[i][j] = "";
                        continue;
                    }
                    if (A[i-1] == B[j-1]) {
                        lcs[i][j] = lcs[i - 1][j - 1] + 1;
                        lcsStr[i][j] = lcsStr[i - 1][j - 1] + A[i-1];
                        // 递推过程中要不断更新当前最大值
                        if (lcs[i][j] > lcsMax) {
                            lcsMax = lcs[i][j];
                            lcsStrMax = lcsStr[i][j];
                        }
                    } else {
                        lcs[i][j] = 0;
                        lcsStr[i][j] = "";
                    }
                }
            }
            System.out.println(lcsStrMax);
            return lcsMax;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.findLength(
                ListNode.stringToIntegerArray("[1,2,3,2,1]"), ListNode.stringToIntegerArray("[3,2,1,4,7]")));
        System.out.println(solutionV2020.findLength(
                ListNode.stringToIntegerArray("[0,1,1,1,1]"), ListNode.stringToIntegerArray("[1,0,1,0,1]")));
        System.out.println(solutionV2020.findLength(
                ListNode.stringToIntegerArray("[1,0,0,0,1]"), ListNode.stringToIntegerArray("[1,0,0,1,1]")));
    }
}

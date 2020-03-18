package leetcode.leetcode;
/**
 * 判断是否子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 * @author masikkk.com
 * @create 2020-02-08 15:47
 */
public class _392_IsSubsequence {
    private static class SolutionV2020 {
        public boolean isSubsequence(String s, String t) {
            if (null == s || null == t) {
                return null == s;
            }
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            int i = 0, j = 0;
            for (; i < ss.length && j < tt.length; j++) {
                if (ss[i] == tt[j]) {
                    i++;
                }
            }
            return i == ss.length;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.isSubsequence("abc", "ahbgdc"));
        System.out.println(solutionV2020.isSubsequence("axc", "ahbgdc"));
        System.out.println(solutionV2020.isSubsequence("", "ahbgdc"));
    }
}

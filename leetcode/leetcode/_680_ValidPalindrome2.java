package leetcode.leetcode;

/**
 * 验证回文字符串 Ⅱ
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @author masikkk.com 2020-05-19 18:21
 */
public class _680_ValidPalindrome2 {
    private static class SolutionV202005 {
        public boolean validPalindrome(String s) {
            if (null == s || s.length() < 2) {
                return true;
            }
            char[] chars = s.toCharArray();
            for (int i = 0, j = chars.length-1; i <= j; i++, j--) {
                if (chars[i] != chars[j]) {
                    // i+1 表示跳过 i 下标处的字符，j-1 表示跳过 j 下标处的字符，继续比较
                    return isPalindrome(chars, i+1, j) || isPalindrome(chars, i, j-1);
                }
            }
            return true;
        }

        // 判断 chars[start...end] 是否回文
        private boolean isPalindrome(char[] chars, int start, int end) {
            for (int i = start, j = end; i <= j; i++, j--) {
                if (chars[i] != chars[j]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.validPalindrome("aba"));
        System.out.println(solutionV202005.validPalindrome("abca"));
    }
}
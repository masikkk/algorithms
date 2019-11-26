package _005_LongestPalindromicSubstring;

/**
 * @author madaimeng.com
 */
public class LongestPalindromicSubstringV2019 {
    private static class Solution {
        public String longestPalindrome(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                String extend1 = extend(s, i, i);
                result = extend1.length() > result.length() ? extend1 : result;
                if (i + 1 < s.length()) {
                    String extend2 = extend(s, i, i + 1);
                    result = extend2.length() > result.length() ? extend2 : result;
                }
            }
            return result;
        }

        public String extend(String s, int pivot1, int pivot2) {
            while (pivot1 >= 0 && pivot2 < s.length() && s.charAt(pivot1) == s.charAt(pivot2)) {
                pivot1--;
                pivot2++;
            }
            return s.substring(pivot1+1, pivot2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("cabcba"));
        System.out.println(solution.longestPalindrome("bb"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome(""));
    }
}

package problems;

/**
 * 最长回文子串
 * @author madaimeng.com
 * @create: 2019-11-22 16:57
 */
public class _005_LongestPalindromicSubstring {
    private static class SolutionV2020 {
        public String longestPalindrome(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                // 以i为中心扩展
                String extend1 = extend(s, i, i);
                result = extend1.length() > result.length() ? extend1 : result;
                if (i + 1 < s.length()) {
                    // 以 i,i+1 为中心扩展，应对长度为偶数的情况
                    String extend2 = extend(s, i, i + 1);
                    result = extend2.length() > result.length() ? extend2 : result;
                }
            }
            return result;
        }

        // 从 pivot1, pivot2 开始分别往左右扩展，返回最长的回文子串
        public String extend(String s, int pivot1, int pivot2) {
            while (pivot1 >= 0 && pivot2 < s.length() && s.charAt(pivot1) == s.charAt(pivot2)) {
                pivot1--;
                pivot2++;
            }
            return s.substring(pivot1+1, pivot2);
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.longestPalindrome("babad"));
        System.out.println(solutionV2020.longestPalindrome("cbbd"));
        System.out.println(solutionV2020.longestPalindrome("cabcba"));
        System.out.println(solutionV2020.longestPalindrome("bb"));
        System.out.println(solutionV2020.longestPalindrome("a"));
        System.out.println(solutionV2020.longestPalindrome(""));
    }
}

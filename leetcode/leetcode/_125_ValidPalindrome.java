package leetcode.leetcode;

/**
 * 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 * @author masikkk.com 2020-06-19 17:18
 */
public class _125_ValidPalindrome {
    private static class SolutionV202006 {
        public boolean isPalindrome(String s) {
            if (null == s || s.equals("")) {
                return true;
            }
            for (int left = 0, right = s.length() - 1; left < right;) {
                // 跳过非数字和字母
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                    continue;
                }
                // 将数字和字母转为小写并比较
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.isPalindrome("abbbcbbba"));
        System.out.println(solutionV202006.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solutionV202006.isPalindrome("race a car"));
    }
}
package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 * @author masikkk.com
 * @create 2020-03-19 17:33
 */
public class _409_LongestPalindrome {
    private static class SolutionV2020 {
        public int longestPalindrome(String s) {
            if (null == s || s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();

            int length = 0;
            for (char c : chars) {
                Character character = Character.valueOf(c);
                int count = map.getOrDefault(character, 0) + 1;
                // 同一字符出现次数达到2次，就可以被放到回文串中
                if (count >= 2) {
                    length += 2;
                    count -= 2;
                }
                map.put(character, count);
            }
            // 中间可以放一个单独的字符
            for (int count : map.values()) {
                if (count > 0) {
                    length++;
                    break;
                }
            }
            return length;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.longestPalindrome("abccccdd"));
        System.out.println(solutionV2020.longestPalindrome("ab"));
        System.out.println(solutionV2020.longestPalindrome("abb"));
        System.out.println(solutionV2020.longestPalindrome("aa"));
        System.out.println(solutionV2020.longestPalindrome("abbac"));
        System.out.println(solutionV2020.longestPalindrome("a"));
    }
}

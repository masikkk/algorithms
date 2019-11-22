package _003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author madaimeng.com
 * @create: 2019-11-21 17:14
 */
public class LongestSubstringWithoutRepeatingCharactersV2019 {
    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (null == s || 0 == s.length()) {
                return 0;
            }
            HashSet hashSet = new HashSet();
            char[] array = s.toCharArray();
            int maxLength = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length; j++) {
                    if (hashSet.contains(array[j])) {
                        break;
                    } else {
                        hashSet.add(array[j]);
                    }
                }
                maxLength = hashSet.size() > maxLength ? hashSet.size() : maxLength;
                hashSet.clear();
            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("2"));
    }
}

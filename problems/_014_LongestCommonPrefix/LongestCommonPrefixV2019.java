package _014_LongestCommonPrefix;

import java.util.Arrays;

/**
 * 最长公共前缀
 * @author madaimeng.com
 * @create: 2019-11-26 16:56
 */
public class LongestCommonPrefixV2019 {
    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (0 == strs.length) {
                return "";
            }
            int i = 0, j = 0;
            for (; i < strs[0].length(); i++) {
                for (j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0].substring(0, i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"abc","abc"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"flower"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"abcdd","a"}));
        System.out.println(solution.longestCommonPrefix(new String[]{""}));
        System.out.println(solution.longestCommonPrefix(new String[]{}));
    }
}

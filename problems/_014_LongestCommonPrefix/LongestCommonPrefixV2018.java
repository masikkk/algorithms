package _014_LongestCommonPrefix;

/**
 * 最长公共前缀
 * @author madaimeng.com
 * @create: 2018-02-08 12:06
 */
public class LongestCommonPrefixV2018 {
    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String prefix = "";
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length()) {
                        return prefix;
                    }
                    if (c != strs[j].charAt(i)) {
                        return prefix;
                    }
                }
                prefix += c;//c在所有字符串中出现
            }
            return prefix;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}

package leetcode.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author madaimeng.com
 */
public class _014_LongestCommonPrefix {
    private static class SolutionV2018 {
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

    @Test
    public void testSolutionV2018() {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.longestCommonPrefix(new String[] {}));
    }

    private static class SolutionV2019 {
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

    @Test
    public void testSolutionV2019() {
        SolutionV2019 solutionV2019 = new SolutionV2019();
        System.out.println(solutionV2019.longestCommonPrefix(new String[]{"abc", "abc"}));
        System.out.println(solutionV2019.longestCommonPrefix(new String[]{"flower"}));
        System.out.println(solutionV2019.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solutionV2019.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(solutionV2019.longestCommonPrefix(new String[]{"abcdd", "a"}));
        System.out.println(solutionV2019.longestCommonPrefix(new String[]{""}));
        System.out.println(solutionV2019.longestCommonPrefix(new String[]{}));
    }

    private static class SolutionV202006 {
        public String longestCommonPrefix(String[] strs) {
            if (null == strs || strs.length < 1) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                char ch = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                        return sb.toString();
                    }
                }
                sb.append(ch);
            }
            return sb.toString();
        }
    }

    @Test
    public void testSolutionV202006() {
        SolutionV202006 solutionV202006 = new SolutionV202006();
        System.out.println(solutionV202006.longestCommonPrefix(new String[]{"abc", "abc"}));
        System.out.println(solutionV202006.longestCommonPrefix(new String[]{"flower"}));
        System.out.println(solutionV202006.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solutionV202006.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(solutionV202006.longestCommonPrefix(new String[]{"abcdd", "a"}));
        System.out.println(solutionV202006.longestCommonPrefix(new String[]{""}));
        System.out.println(solutionV202006.longestCommonPrefix(new String[]{}));
    }
}

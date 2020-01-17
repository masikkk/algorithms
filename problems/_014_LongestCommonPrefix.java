/**
 * 最长公共前缀
 * @author madaimeng.com
 * @create: 2018-02-08 12:06
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

    private static class SolutionV2020 {
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
        SolutionV2018 solution = new SolutionV2018();
        String[] strs = {};
        System.out.println(solution.longestCommonPrefix(strs));

        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.longestCommonPrefix(new String[]{"abc","abc"}));
        System.out.println(solutionV2020.longestCommonPrefix(new String[]{"flower"}));
        System.out.println(solutionV2020.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solutionV2020.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(solutionV2020.longestCommonPrefix(new String[]{"abcdd","a"}));
        System.out.println(solutionV2020.longestCommonPrefix(new String[]{""}));
        System.out.println(solutionV2020.longestCommonPrefix(new String[]{}));
    }
}

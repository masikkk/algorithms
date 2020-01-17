package problems;

public class _028_Implement_StrStr {
    private static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.length() == 0) {
                return 0;
            }
            char[] s = haystack.toCharArray();
            char[] p = needle.toCharArray();
            for (int i = 0; i <= s.length - p.length; ) {
                for (int j = 0; j < p.length; ) {
                    if (s[i] == p[j]) {
                        i++;
                        j++;
                    } else {
                        i = i - j + 1;
                        break;
                    }
                    if (j == p.length) {
                        return i - j;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("", ""));
    }
}

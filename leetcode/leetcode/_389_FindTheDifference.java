package leetcode.leetcode;

public class _389_FindTheDifference {
    private static class Solution {
        //集合ASC||码值之差
        public char findTheDifference(String s, String t) {
            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();
            int tSum = 0;
            for (char c : tchar) { //t中字符ascii码值之和
                tSum += c;
            }
            for (char c : schar) { //减去s中字符ascii码值之和
                tSum -= c;
            }
            return (char) tSum;
        }

        //暴力搜索法
        public char findTheDifference1(String s, String t) {
            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();
            for (char ch : schar) {
                for (int i = 0; i < tchar.length; i++) {
                    if (ch == tchar[i]) {
                        tchar[i] = 'A';
                        break;
                    }
                }
            }
            char result = tchar[0];
            for (char c : tchar) {
                if (c != 'A') {
                    result = c;
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println((int) 'a');
        System.out.println(solution.findTheDifference("abcd", "abcde"));
    }
}

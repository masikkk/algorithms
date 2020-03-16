package problems;
/**
 * 压缩字符串
 * https://leetcode-cn.com/problems/compress-string-lcci/
 * @author masikkk.com
 * @create 2020-03-16 18:52
 */
public class Crack_0106_CompressString {
    private static class SolutionV2020 {
        public String compressString(String s) {
            if (null == s || s.length() < 3) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            char ch = chars[0];
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == ch) {
                    count++;
                } else {
                    sb.append(ch).append(count);
                    ch = chars[i];
                    count = 1;
                }
            }
            sb.append(ch).append(count);
            return sb.toString().length() < s.length() ? sb.toString() : s;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.compressString("aabcccccaaa"));
        System.out.println(solutionV2020.compressString("abbccd"));
        System.out.println(solutionV2020.compressString("abb"));
    }
}

package leetcode.leetcode;

/**
 * 反转字符串
 */
public class _344_ReverseString {
    private static class SolutionV2018 {
        //char swap
        public String reverseString(String s) {
            char[] charStr = s.toCharArray();
            int length = s.length();
            for (int i = 0; i < length / 2; i++) {
                char temp = charStr[i];
                charStr[i] = charStr[length - 1 - i];
                charStr[length - 1 - i] = temp;
            }
            String result = new String(charStr);
            return result;
        }

        //第一次提交: Time Limit Exceeded
        public String reverseString1(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                result = s.charAt(i) + result;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        SolutionV2018 solution = new SolutionV2018();
        System.out.println(solution.reverseString("Masikkk"));
    }
}

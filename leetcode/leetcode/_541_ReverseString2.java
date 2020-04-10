package leetcode.leetcode;

/**
 * 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class _541_ReverseString2 {
    private static class SolutionV2018 {
        public String reverseStr(String s, int k) {
            StringBuilder result = new StringBuilder("");
            int i = 0;
            int lastIndex = 0;//上一个下标位
            int lastEvenEndIndex = -1;//上一个偶数段结束位
            while (i < s.length()) {
                if ((i + 1) % k == 0) {//遍历到一个完整的奇数段
                    result.append(new StringBuilder(s.substring(i - k + 1, i + 1)).reverse());//加上奇数段反转
                    result.append(s.substring(i + 1, i + k + 1 > s.length() ? s.length() : i + k + 1));//加上偶数段
                    lastIndex = i;//上一个下标位
                    lastEvenEndIndex = i + k;//上一个偶数段结束位
                    i += k + 1;//跳过偶数段
                } else {
                    lastIndex = i;
                    i++;
                }
            }
            if (lastIndex == i - 1) {//在奇数段结束，即剩余字符不足k个
                result.append(new StringBuilder(s.substring(lastEvenEndIndex + 1)).reverse());//加上剩余奇数段的反转
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.reverseStr("abcdefg", 10));
    }
}

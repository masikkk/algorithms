package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 每个元音包含偶数次的最长子字符串
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * @author masikkk.com 2020-05-20 18:07
 */
public class _1371_LongestSubstringContainingEvenVowels {
    private static class SolutionV202005 {
        public int findTheLongestSubstring(String s) {
            if (null == s || s.length() < 1) {
                return 0;
            }
            // a,e,i,o,u 的奇偶状态，低 5 位分别表示每个元音的奇偶状态，第 0 位表示 a 的奇偶状态，依次类推，0 表示偶， 1表示奇
            int status = 0;
            // 每个奇偶状态的最小下标
            Map<Integer, Integer> map = new HashMap<>();
            // 先放入一个 a,e,i,o,u 全为0的状态，下标为 -1
            map.put(0, -1);
            int maxLength = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'a') {
                    status ^= 1;
                } else if (chars[i] == 'e') {
                    status ^= (1 << 1);
                } else if (chars[i] == 'i') {
                    status ^= (1 << 2);
                } else if (chars[i] == 'o') {
                    status ^= (1 << 3);
                } else if (chars[i] == 'u') {
                    status ^= (1 << 4);
                }
                if (map.containsKey(status)) {
                    // 遇到奇偶状态相同的，则当前位置到此状态的最小下标之间的子数组满足条件（每个元音包含偶数次）
                    maxLength = Math.max(maxLength, i - map.get(status));
                } else {
                    // 放入此状态的最小下标
                    map.put(status, i);
                }
            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.findTheLongestSubstring("aaaa"));
        System.out.println(solutionV202005.findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(solutionV202005.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(solutionV202005.findTheLongestSubstring("bcbcbc"));
    }
}
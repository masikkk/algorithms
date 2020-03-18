package leetcode.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 最长非重复子串
 * @author madaimeng.com
 * @create: 2018-02-04 12:06
 */
public class _003_LongestSubstringWithoutRepeatingCharacters {
    private static class SolutionV2018 {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            int len = 0;
            String maxSub = "";
            String sub = "";
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); ) {
                if (map.containsKey(s.charAt(i))) {
                    max = len > max ? len : max;
                    maxSub = sub.length() > maxSub.length() ? sub : maxSub;
                    len = 0;
                    sub = "";
                    i = map.get(s.charAt(i)) + 1;
                    map.clear();
                } else {
                    map.put(s.charAt(i), i);
                    sub += s.charAt(i);
                    len++;
                    i++;
                }
            }
            max = len > max ? len : max;
            maxSub = sub.length() > maxSub.length() ? sub : maxSub;
            System.out.println(maxSub);
            return max;
        }

        public int lengthOfLongestSubstring2(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    System.out.print("i:" + i + ",j:" + j + ",重复:" + s.charAt(j) + "，s.charAt(" + j + "): " + map.get(s.charAt(j)));
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                System.out.println("， i:" + i + ",j:" + j + ", ans:" + ans);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }

        public static void main(String[] args) {
            SolutionV2018 solution = new SolutionV2018();
            System.out.println(solution.lengthOfLongestSubstring("abba"));//abbba
            System.out.println(solution.lengthOfLongestSubstring2("abba"));
        }
    }

    private static class SolutionV2020 {
        public int lengthOfLongestSubstring(String s) {
            if (null == s || 0 == s.length()) {
                return 0;
            }
            HashSet hashSet = new HashSet();
            char[] array = s.toCharArray();
            int maxLength = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length; j++) {
                    if (hashSet.contains(array[j])) {
                        break;
                    } else {
                        hashSet.add(array[j]);
                    }
                }
                maxLength = hashSet.size() > maxLength ? hashSet.size() : maxLength;
                hashSet.clear();
            }
            return maxLength;
        }

        public static void main(String[] args) {
            SolutionV2020 solutionV2020 = new SolutionV2020();
            System.out.println(solutionV2020.lengthOfLongestSubstring("abcabcbb"));
            System.out.println(solutionV2020.lengthOfLongestSubstring("bbbbb"));
            System.out.println(solutionV2020.lengthOfLongestSubstring("pwwkew"));
            System.out.println(solutionV2020.lengthOfLongestSubstring("2"));
        }
    }
}

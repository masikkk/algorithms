package leetcode.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.junit.jupiter.api.Test;

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
            Map<Character, Integer> map = new HashMap<>();
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
    }

    @Test
    public void testSolutionV2018() {
        SolutionV2018 solutionV2018 = new SolutionV2018();
        System.out.println(solutionV2018.lengthOfLongestSubstring("abba"));//abbba
        System.out.println(solutionV2018.lengthOfLongestSubstring2("abba"));
    }

    private static class SolutionV202001 {
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
    }

    @Test
    public void testSolutionV202001() {
        SolutionV202001 solutionV202001 = new SolutionV202001();
        System.out.println(solutionV202001.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solutionV202001.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solutionV202001.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solutionV202001.lengthOfLongestSubstring("2"));
    }

    private static class SolutionV202005 {
        public int lengthOfLongestSubstring(String s) {
            if (null == s || s.length() < 1) {
                return 0;
            }
            int max = 0;
            // map 保存窗口内的元素，字符 -> 下标
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length;) {
                Character character = new Character(chars[i]);
                if (!map.containsKey(character)) {
                    map.put(character, i);
                    max = Math.max(max, map.size());
                    i++;
                } else {
                    // chars[i]和当前滑动窗口内字符重复，则下次滑动窗口从重复位置的下一个重新开始
                    i = map.get(character) + 1;
                    map.clear();
                }
            }
            return max;
        }
    }

    @Test
    public void testSolutionV202005() {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solutionV202005.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solutionV202005.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solutionV202005.lengthOfLongestSubstring("2"));
        System.out.println(solutionV202005.lengthOfLongestSubstring("aab"));
    }
}

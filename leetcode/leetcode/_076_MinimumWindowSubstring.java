package leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * @author masikkk.com 2020-05-23 21:22
 */
public class _076_MinimumWindowSubstring {
    private static class SolutionV202005 {
        public String minWindow(String s, String t) {
            if (null == t || t.length() < 1 || null == s || s.length() < 1 || s.length() < t.length()) {
                return "";
            }
            // t 串 Map
            Map<Character, Integer> tMap = new HashMap<>();
            for (char ch: t.toCharArray()) {
                tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
            }
            // 窗口内元素 Map
            Map<Character, Integer> windowMap = new HashMap<>();
            // 最小覆盖子串
            String minCoverStr = "";

            char[] schars = s.toCharArray();
            for (int left = 0, right = 0; right < schars.length; right++) {
                // 扩张右边界 right
                windowMap.put(schars[right], windowMap.getOrDefault(schars[right], 0) + 1);
                if (contain(windowMap, tMap)) {
                    // 窗口内元素已覆盖 t，更新最小覆盖子串，并收缩窗口，右移左边界 left，直到窗口无法覆盖 t
                    do {
                        // 更新最小覆盖子串
                        if (minCoverStr.equals("") || right - left + 1 < minCoverStr.length()) {
                            minCoverStr = s.substring(left, right + 1);
                        }
                        int count = windowMap.get(schars[left]);
                        if (count > 1) {
                            windowMap.put(schars[left], count - 1);
                        } else {
                            windowMap.remove(schars[left]);
                        }
                        left++;
                    } while (contain(windowMap, tMap));
                }
            }
            return minCoverStr;
        }

        // tMap 中 key 都在 sMap 中，且对应 value 大于等于 tMap 中 value 时返回 true
        private boolean contain(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
            for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
                if (sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        SolutionV202005 solutionV202005 = new SolutionV202005();
        System.out.println(solutionV202005.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solutionV202005.minWindow("BABC", "ABC"));
        System.out.println(solutionV202005.minWindow("a", "aa"));
        System.out.println(solutionV202005.minWindow("a", "b"));
    }
}
package _003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长非重复子串
 * @author madaimeng.com
 * @create: 2018-02-04 12:06
 */
public class LongestSubstringWithoutRepeatingCharactersV2018 {
    private static class Solution {
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

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));//abbba
        System.out.println(solution.lengthOfLongestSubstring2("abba"));
    }
}

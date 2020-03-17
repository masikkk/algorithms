package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 拼写单词
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 * @author masikkk.com
 * @create 2020-03-17 15:06
 */
public class _1160_FindWordsThatCanBeFormedByCharacters {
    private static class SolutionV2020 {
        public int countCharacters(String[] words, String chars) {
            if (null == words || 0 == words.length || null == chars || chars.length() == 0) {
                return 0;
            }
            int sum = 0;

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                boolean good = true;
                // 每次都要初始化字典表
                Map<String, Integer> dictMap = initDictMap(chars);
                for (int j = 0; j < word.length(); j++) {
                    String ch = String.valueOf(word.charAt(j));
                    if (dictMap.getOrDefault(ch, 0) == 0) {
                        good = false;
                        break;
                    } else {
                        dictMap.put(ch, dictMap.get(ch) - 1);
                    }
                }
                if (good) {
                    sum += word.length();
                }
            }
            return sum;
        }

        // 初始化字典 map， 字符 -> 出现次数
        private Map<String, Integer> initDictMap(String chars) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < chars.length(); i++) {
                String ch = String.valueOf(chars.charAt(i));
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            return map;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.countCharacters(new String[] {"cat","bt","hat","tree"}, "atach"));
        System.out.println(solutionV2020.countCharacters(new String[] {"hello","world","leetcode"}, "welldonehoneyr"));
    }
}

package leetcode.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 单词的压缩编码
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 * @author masikkk.com
 * @create 2020-03-28 18:20
 */
public class _820_ShortEncodingOfWords {
    private static class SolutionV2020 {
        public int minimumLengthEncoding(String[] words) {
            if (null == words || words.length == 0) {
                return 0;
            }
            List<String> list = new LinkedList<>();
            for (String word : words) {
                boolean exist = false;
                for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
                    String encodeStr = iterator.next();
                    if (encodeStr.endsWith(word)) {
                        exist = true;
                        break;
                    } else if (word.endsWith(encodeStr)) {
                        iterator.set(word);
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    list.add(word);
                }
            }
            int count = 0;
            for (String s : list) {
                count += s.length() + 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(solutionV2020.minimumLengthEncoding(new String[]{"c", "bc", "abc"}));
        System.out.println(solutionV2020.minimumLengthEncoding(new String[]{"bc", "abc", "c", "a", "b"}));
    }
}

package leetcode.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import structs.TrieNode;

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

    // 官方前缀树解法
    private static class OfficeSolution {
        public int minimumLengthEncoding(String[] words) {
            TrieNode trie = new TrieNode();
            Map<TrieNode, Integer> nodes = new HashMap();

            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                TrieNode cur = trie;
                for (int j = word.length() - 1; j >= 0; --j)
                    cur = cur.get(word.charAt(j));
                nodes.put(cur, i);
            }

            int ans = 0;
            for (TrieNode node: nodes.keySet()) {
                if (node.count == 0)
                    ans += words[nodes.get(node)].length() + 1;
            }
            return ans;

        }
    }

    public static void main(String[] args) {
        SolutionV2020 solutionV2020 = new SolutionV2020();
        System.out.println(solutionV2020.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(solutionV2020.minimumLengthEncoding(new String[]{"c", "bc", "abc"}));
        System.out.println(solutionV2020.minimumLengthEncoding(new String[]{"bc", "abc", "c", "a", "b"}));

        OfficeSolution officeSolution = new OfficeSolution();
        System.out.println(officeSolution.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(officeSolution.minimumLengthEncoding(new String[]{"c", "bc", "abc"}));
        System.out.println(officeSolution.minimumLengthEncoding(new String[]{"bc", "abc", "c", "a", "b"}));
    }
}

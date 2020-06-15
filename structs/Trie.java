package structs;

import org.junit.jupiter.api.Test;

/**
 * 前缀树/字典树
 * @author masikkk.com
 * @create 2020-03-28 22:26
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入单词 word
    public void insert(String word) {
        TrieNode trieNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (trieNode.containChar(c)) {
                trieNode = trieNode.get(c);
            } else {
                trieNode = trieNode.insertChar(c);
            }
        }
        trieNode.isEnd = true;
    }

    // 判断单词 word 是否在前缀树中，单词 word 在前缀树中时返回 true
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!trieNode.containChar(c)) {
                return false;
            } else {
                trieNode = trieNode.get(c);
            }
        }
        return trieNode.isEnd;
    }

    // 判断前缀 prefix 是否在前缀树中
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!trieNode.containChar(c)) {
                return false;
            } else {
                trieNode = trieNode.get(c);
            }
        }
        return true;
    }

    // 前缀树结点
    public static class TrieNode {
        private TrieNode[] children; // 子树结点数组，下标为 i 的子树表示以字符 i+'a' 为根的子树
        private int count; // 子树个数
        private boolean isEnd; // 当前节点是否单词结尾

        private TrieNode() {
            children = new TrieNode[26];
            count = 0;
            isEnd = false;
        }

        // 是否包含字符 c
        private boolean containChar(char c) {
            return children[c - 'a'] != null;
        }

        // 返回以字符 c 为根的子树
        private TrieNode get(char c) {
            return children[c - 'a'];
        }

        // 插入字符 c 并返回以 c 为根的子树
        private TrieNode insertChar(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }

    @Test
    public void testTrie() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}

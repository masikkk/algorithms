package structs;

/**
 * 前缀树/字典树
 * @author masikkk.com
 * @create 2020-03-28 22:26
 */
public class TrieNode {
    public TrieNode[] children;
    public int count;
    public TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}

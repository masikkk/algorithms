package structs;

import java.util.List;

/**
 * 多叉树结点
 * @author masikkk.com
 * @create 2020-02-01 17:24
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

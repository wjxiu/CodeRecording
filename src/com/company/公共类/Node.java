package company.公共类;

import java.util.List;

/**
 * @author xiu
 * @create 2023-07-14 20:04
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
};

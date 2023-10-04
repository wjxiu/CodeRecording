package com.company.二叉树.层序遍历;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-14 20:13
 */
public class 填充每个节点的下一个右侧节点指针 {
    public Nodet connect(Nodet root) {
        if (root!=null) help(root);
        return root;
    }
    public void help(Nodet root) {
        LinkedList<Nodet> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Nodet> temp = new ArrayList<>();
            while (size > 0) {
                Nodet pop = queue.pop();
                temp.add(pop);
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
                size--;
            }
            for (int i = 0; i < temp.size()-1; i++) {
                temp.get(i).next= temp.get(i+1);
            }
            temp.get(temp.size()-1).next=null;
        }
    }
}
class Nodet {
    public int val;
    public Nodet left;
    public Nodet right;
    public Nodet next;

    public Nodet() {}

    public Nodet(int _val) {
        val = _val;
    }

    public Nodet(int _val, Nodet _left, Nodet _right, Nodet _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
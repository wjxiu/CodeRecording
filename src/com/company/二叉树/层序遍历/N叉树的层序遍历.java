package com.company.二叉树.层序遍历;

import com.company.公共类.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-14 20:03
 */
public class N叉树的层序遍历 {
    List<List<Integer>> list =new ArrayList();
    public List<List<Integer>> levelOrder(Node root) {
        if (root!=null){
            help(root);
        }
        return list;
    }
    public void help(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size > 0) {
                Node pop = queue.pop();
                temp.add(pop.val);
                if (pop.children != null) queue.addAll(pop.children);
                size--;
            }
            list.add(temp);
        }
    }
}

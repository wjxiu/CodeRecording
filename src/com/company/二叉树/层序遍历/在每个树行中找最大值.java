package com.company.二叉树.层序遍历;

import com.company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-14 20:08
 */
public class 在每个树行中找最大值 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root!=null) help(root);
        return list;
    }
    public void help(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
           Integer max=Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode pop = queue.pop();
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
                max=Math.max(max,pop.val);
                size--;
            }
            list.add(max);
        }
    }
}

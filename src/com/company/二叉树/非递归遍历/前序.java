package com.company.二叉树.非递归遍历;

import com.company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author xiu
 * @create 2023-10-15 18:03
 */
public class 前序 {
    static void preOrderTraversal(TreeNode root) {
        if (root==null)return;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right!=null)stack.add(pop.right);
            if (pop.left!=null)stack.add(pop.left);
        }
        System.out.println(list);
    }
}

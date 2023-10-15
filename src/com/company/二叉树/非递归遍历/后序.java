package com.company.二叉树.非递归遍历;

import com.company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author xiu
 * @create 2023-10-15 18:04
 */
public class 后序 {
    static void postOrderTraversal(TreeNode root){
        if (root==null)return;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.left!=null) stack.push(pop.left);
            if (pop.right!=null) stack.push(pop.right);
        }
        Collections.reverse(list);
        System.out.println(list);
    }
}

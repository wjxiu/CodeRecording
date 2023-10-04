package com.company.二叉树;

import com.company.公共类.TreeNode;

import java.util.*;

/**
 * @author xiu
 * @create 2023-07-14 16:16
 */
public class 迭代遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        new 迭代遍历().inorderTraversal(treeNode);
    }
    //    迭代 前序
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.left != null) stack.add(pop.left);
            if (pop.right != null) stack.add(pop.right);
        }
        return list;
    }

    //    迭代后序
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null) stack.add(pop.right);
            if (pop.left != null) stack.add(pop.left);
        }
        Collections.reverse(list);
        return list;
    }

    //    迭代中序
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root= stack.pop();
                 list.add(root.val);
                root=root.right;
            }
        }
        return list;
    }
}

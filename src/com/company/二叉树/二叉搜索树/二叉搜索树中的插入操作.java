package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-16 11:54
 */
public class 二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode temp=root;
        while (root!=null){
            if (val>root.val){
                if (root.right!=null){
                    root=root.right;
                }else{
                    root.right=new TreeNode(val);
                    break;
                }
            }else{
                if (root.left!=null){
                    root=root.left;
                }else{
                    root.left=new TreeNode(val);
                    break;
                }
            }
        }
        return temp;
    }
}

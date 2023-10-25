package com.company.二叉树;

import com.company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-10-25 14:49
 */
public class 具有所有最深节点的最小子树 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null)return null;
        Object[] d=depth(root);
        return (TreeNode) d[0];
    }
    Object[] depth(TreeNode root){
        if(root==null)return new Object[]{null,0};
        Object[] left=depth(root.left);
        Object[] right=depth(root.right);
        int leftnum = (int) left[1];
        int rightnum=(int)right[1];
        if(leftnum >rightnum){
            return new Object[]{left[0],leftnum+1};
        }else if(leftnum <rightnum){
            return new Object[]{right[0],rightnum+1};
        }else{
            return new Object[]{root,rightnum+1};
        }
    }
}

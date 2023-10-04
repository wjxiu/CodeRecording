package com.company.二叉树.层序遍历;

import com.company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-14 21:45
 */
public class 二叉树的最小深度 {
//    没有经典的代理
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left!=null&root.right==null){
            return 1+minDepth(root.left);
        }
       else if (root.right!=null&root.left==null){
            return 1+minDepth(root.right);
        }else{
           return 1+Math.min(minDepth(root.left),minDepth(root.right));
        }
    }
//    精简后的
    public int minsimple(TreeNode root){
        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 1;
        int min=Integer.MAX_VALUE;
        if (root.left!=null) min=Math.min(minsimple(root.left),min);
        if (root.right!=null) min=Math.min(minsimple(root.right),min);
        return 1+min;
    }
}

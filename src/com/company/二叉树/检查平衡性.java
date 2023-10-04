package com.company.二叉树;
import com.company.公共类.TreeNode;
/**
 * @author xiu
 * @create 2023-09-03 8:56
 */
public class 检查平衡性 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        if (Math.abs(height(root.left)-height(root.right))>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    private int height(TreeNode root){
        if (root==null) return 0;
       return  Math.max(height(root.left),height(root.right))+1;
    }
}

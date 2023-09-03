package com.company.二叉树;
import company.公共类.TreeNode;
/**
 * @author xiu
 * @create 2023-09-03 8:56
 */
public class 检查平衡性 {
    public static void main(String[] args) {
        System.out.println(new 检查平衡性().isBalanced(TreeNode.geneTree(3, 9, 20, null, null, 15, 7)));
    }
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

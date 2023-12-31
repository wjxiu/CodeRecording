package com.company.二叉树;

import com.company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-14 21:31
 */
public class 对称二叉树 {
    public static void main(String[] args) {
        System.out.println(isSymmetric2(TreeNode.geneTree(1, 2, 2, 3, 4, 4)));
    }
//    应该必须有辅助函数
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return  help1(root.left,root.right);
    }
    boolean help(TreeNode left,TreeNode right){
         if(left==null&&right==null)return true;
         else if(left==null||right==null) return false;
         else if(left.val!=right.val) return false;
         return help(left.left,right.right)&&help(left.right,right.left);
    }

    boolean help1(TreeNode left,TreeNode right){
        if (left==null&&right==null) return true;
        if (left==null||right==null) return false;
        if (left.val!=right.val) return false;
        return help1(left.right,right.left)&&help1(left.left,right.right);

    }



    public static boolean isSymmetric2(TreeNode root) {
        if(root==null) return true;
        return check(root.left,root.right);
    }
    public static boolean check(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        else if(left!=null&&right!=null){
            return  check(left.left,right.right)&&
                    check(left.right,right.left)&&left.val==right.val;
        }
        else return false;
    }
}

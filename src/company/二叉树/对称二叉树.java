package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-14 21:31
 */
public class 对称二叉树 {
//    应该必须有辅助函数
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return  help(root.left,root.right);
    }
    boolean help(TreeNode left,TreeNode right){
         if(left==null&&right==null)return true;
         else if(left==null||right==null) return false;
         else if(left.val!=right.val) return false;
         return help(left.left,right.right)&&help(left.right,right.left);
    }
}

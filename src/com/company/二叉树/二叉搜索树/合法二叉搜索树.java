package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-09-05 20:37
 */
public class 合法二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(3 * 0.1 );
        System.out.println(new 合法二叉搜索树().isValidBST1(TreeNode.geneTree(2,8,3)));
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, Long left, Long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) return false;
        return isValid(root.left, left, Long.parseLong(root.val + "")) &&
                isValid(root.right, Long.parseLong(root.val + ""), right);
    }

    //    利用中序遍历有序,使用pre变量保存上一次的遍历结果
    Long pre=Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode treeNode) {
        if (treeNode==null) return true;
        if(!isValidBST1(treeNode.left)||pre<treeNode.val) return false;
        Long pre=Long.parseLong(treeNode.val+"");
        return isValidBST1(treeNode.right);
    }
}

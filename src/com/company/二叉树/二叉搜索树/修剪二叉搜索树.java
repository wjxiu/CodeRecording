package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-16 14:21
 */
public class 修剪二叉搜索树 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.geneTree(new Integer[]{3, 0, 4, null, 2, null, null, 1});
        TreeNode treeNode1 = new 修剪二叉搜索树().trimBST1(treeNode, 1, 3);
        System.out.println(Arrays.toString(TreeNode.parse(treeNode1)));
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val < low) {
//            递归右子树
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }

    public TreeNode trimBST1(TreeNode root, int low, int high){
        if (root.val<low||root.val>high) return null;
        if (root.left!=null) root.left= trimBST(root.left, low, high);
        if (root.right!=null) root.right=trimBST(root.right, low, high);
        return root;
    }

}

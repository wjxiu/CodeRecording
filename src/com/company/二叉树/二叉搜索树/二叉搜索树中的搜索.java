package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 15:00
 */
public class 二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val > root.val)
            return searchBST(root.right, val);
         else if (val < root.val)
            return searchBST(root.left, val);
         else return root;
    }
}

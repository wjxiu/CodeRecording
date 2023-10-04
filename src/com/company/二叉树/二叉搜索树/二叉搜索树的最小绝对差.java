package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

import java.util.ArrayList;

/**
 * @author xiu
 * @create 2023-07-15 21:00
 */
public class 二叉搜索树的最小绝对差 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.geneTree(1,null,3,2);
        System.out.println(new 二叉搜索树的最小绝对差().getMinimumDifference(root));
    }

    ArrayList<Integer> list = new ArrayList<Integer>();
    int res = Integer.MAX_VALUE;

    //    转成有序数组
    public int getMinimumDifference(TreeNode root) {
//        这里要复制为最大值
        pre.val=Integer.MAX_VALUE;
        help2(root);
        return res;
    }

    void help(TreeNode root) {
        if (root == null) return;
        help(root.left);
        list.add(root.val);
        help(root.right);
    }

    TreeNode pre = new TreeNode();

    //    递归，和上面思路一致，但是没有数组保存所有值，保存遍历过程的上一个值
    void help1(TreeNode root) {
        if (root == null) return;
        help1(root.left);
        if (pre.val != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        help1(root.right);
    }

    void help2(TreeNode root) {
        if (root == null) return;
        help2(root.left);
        res = Math.min(res, Math.abs(pre.val - root.val));
        pre = root;
        help2(root.right);
    }
}

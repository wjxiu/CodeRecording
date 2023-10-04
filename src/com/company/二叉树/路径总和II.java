package com.company.二叉树;

import com.company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-29 14:09
 */
public class 路径总和II {
    public static void main(String[] args) {
        System.out.println(new 路径总和II().pathSum(TreeNode.geneTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    //    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        help1(root, targetSum, new ArrayList<>());
        return res;
    }

    public void help(TreeNode root, int tarSum, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == tarSum) {
            res.add(new ArrayList<>(path));
        }
        help(root.left, tarSum - root.val, path);
        help(root.right, tarSum - root.val, path);
//        不用每次调用递归治好后都去掉path的值
        path.remove(path.size() - 1);
    }

    public void help1(TreeNode root, int tarSum, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == tarSum) {
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) help1(root.left, tarSum - root.val, path);
        if (root.right != null) help1(root.right, tarSum - root.val, path);
        path.remove(path.size() - 1);
    }
}

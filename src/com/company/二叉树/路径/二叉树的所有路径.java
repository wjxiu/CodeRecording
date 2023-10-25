package com.company.二叉树.路径;

import com.company.公共类.TreeNode;

import java.util.*;

/**
 * @author xiu
 * @create 2023-07-15 9:41
 */
public class 二叉树的所有路径 {

    public static void main(String[] args) {
//        List<String> res = new 二叉树的所有路径().binaryTreePaths(TreeNode.geneTree(1, 2, 3, 4, 5, 6, 7, 89, 10, 11, 12, 13, 14));
        List<String> res = binaryTreePaths1(TreeNode.geneTree(1, 2, 3, null, 5));
        System.out.println(res);
    }

    static List<String> list = new ArrayList<>();
    static ArrayList<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        help1(root);
        System.out.println(list);
        return list;
    }

    void help(TreeNode root, List<Integer> path) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : path) sb.append(integer).append("->");
            String substring = sb.substring(0, sb.length() - 2);
            list.add(substring);
            path.remove(path.size() - 1);
        }
        path.add(root.val);
        if (root.left != null) help(root.left, path);
        if (root.right != null) help(root.right, path);
//        回溯，这行放在两个if还是单独抽出来都可以
        path.remove(path.size() - 1);
    }


    void help1(TreeNode root) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            StringBuilder sb = new StringBuilder();
            path.forEach(p -> sb.append(p).append("->"));
            list.add(sb.substring(0, sb.length() - 2));
            return;
        }
        path.add(root.val);
        if (root.left != null) help1(root.left);
        path.remove(path.size() - 1);
        if (root.right != null) help1(root.right);
        path.remove(path.size() - 1);


    }


    public static List<String> binaryTreePaths1(TreeNode root) {
        if (root == null) return list;
        help2(root);
        return list;
    }

    static void help2(TreeNode root) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (Integer integer : path) builder.append(integer).append("->");
            String substring = builder.substring(0, builder.length() - 2);
            list.add(substring);
//            这里没有return,因为进入这里也不会进入下面的方法中,也就可以回溯了,所以path.remove也不用写两次
        }
        help2(root.left);
        help2(root.right);
        path.remove(path.size() - 1);
    }
}

package com.company.二叉树.二叉搜索树;

import company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author xiu
 * @create 2023-09-22 10:19
 */
public class 后继者 {
    public static void main(String[] args) {

    }

    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        travsrse(root);
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            if (list.get(i) == p) return list.get(i + 1);
        }
        return null;
    }

    public void travsrse(TreeNode root) {
        if (root == null) return;
        travsrse(root.left);
        list.add(root);
        travsrse(root.right);
    }
}
class test{
    static int a=0;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            boolean isOdd = false;
            for (int i = 1; i <= 2; ++i) {
                if (i % 2 == 1) isOdd = true;
                else isOdd = false;
                a += i * (isOdd ? 1 : -1);
            }
        });
        Thread thread1 = new Thread(() -> {
            boolean isOdd = false;
            for (int i = 1; i <= 2; ++i) {
                if (i % 2 == 1) isOdd = true;
                else isOdd = false;
                a += i * (isOdd ? 1 : -1);
            }
        });
        System.out.println(a);

    }

}
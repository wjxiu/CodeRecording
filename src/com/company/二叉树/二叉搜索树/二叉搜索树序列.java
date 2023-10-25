package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

import java.util.*;

/**
 * @author xiu
 * @create 2023-10-25 15:09
 */
public class 二叉搜索树序列 {
    public static void main(String[] args) {
    }

    static LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    static List<List<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> path = new ArrayList<>();

    public static List<List<Integer>> BSTSequences(TreeNode root) {
        queue.offer(root);
        bfs();
        return res;
    }

    static void bfs() {
        if (queue.isEmpty()) {
            res.add(new ArrayList<>(path));
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode poll = queue.poll();
            if (poll == null) continue;
            path.add(poll.val);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
            bfs();
            path.remove(path.size() - 1);
        }
    }

    static boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1==null&&t2==null)return true;
        if (t1==null||t2==null)return false;
        return isSame(t1,t2)||checkSubTree(t1.left,t2)|| checkSubTree(t1.right,t2);
    }
   static boolean isSame(TreeNode t1, TreeNode t2){
        if (t1==null&&t2==null)return true;
        if (t1==null||t2==null)return false;
       return  t1.val==t2.val&& isSame(t1.left,t2.left)&&isSame(t1.right,t2.right);
    }

}

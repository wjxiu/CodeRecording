package com.company.数组;

import com.company.公共类.TreeNode;
import com.company.公共类.工具类.LeetCodeUtils;

import java.util.*;

/**
 * @author xiu
 * @create 2023-11-03 21:42
 */
public class 摩尔投票 {
    static int majorityElement(int[] nums) {
        int vote = 0;
        int res = 0;
        for (int num : nums) {
            if (vote == 0) {
                res = num;
                vote = 1;
            } else {
                if (num == res) vote++;
                else vote--;
            }
        }
        vote = 0;
        for (int num : nums) if (num == res) vote++;
//        如果没有验证,可能出错,例如{2,2,3,3,4,4}
        if (vote * 2 > nums.length) return res;
        return -1;
    }

    //    给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    public static void main(String[] args) {
        System.out.println(lowestCommonAncestor(TreeNode.geneTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4), new TreeNode(5), new TreeNode(1)));

    }

    static List<Integer> majorityElementII(int[] nums) {
        ArrayList<Object> objects = new ArrayList<>();
        int a = 0;
        int b = 0;
        int ca = 0;
        int cb = 0;
        for (int n : nums) {
            if (ca != 0 && a == n) ca++;
            else if (cb != 0 && b == n) cb++;
            else if (ca == 0 && ++ca >= 0) {
                a = n;
            } else if (cb == 0 && ++cb >= 0) {
                b = n;
            } else {
                ca--;
                cb--;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        ca = 0;
        cb = 0;
        for (int n : nums) {
            if (a == n) ca++;
            else if (b == n) cb++;
        }
        if (ca > nums.length / 3) list.add(a);
        if (cb > nums.length / 3) list.add(b);
        return list;
    }

    static public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList();
        dfs(root, list);
        return list.get(k-1);
    }

    static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root.val==p.val||root.val==q.val)return root;
        TreeNode l=  lowestCommonAncestor(root.left,p,q);
        TreeNode r=  lowestCommonAncestor(root.right,p,q);
        if(l!=null&&r!=null){
            return root;
        }else if(l==null&&r!=null){
            return r;
        }else{
            return l;
        }
    }
}
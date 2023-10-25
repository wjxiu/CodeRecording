package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.ToIntFunction;

/**
 * @author xiu
 * @create 2023-07-15 21:27
 */
public class 二叉搜索树中的众数 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new 二叉搜索树中的众数().findMode(TreeNode.geneTree( 1, null, 2))));
    }

    Integer pre = Integer.MIN_VALUE;
    ArrayList<Integer> list = new ArrayList<>();
    HashSet<Integer> set = new HashSet<Integer>();
    int maxcount = 0;

    public int[] findMode(TreeNode root) {
        if(root==null)return new int[]{};
        if(root.left==null&&root.right==null)return new int[]{root.val};
        help1(root);
        return set.stream().mapToInt(value -> value).toArray();
    }

    int count = 0;

    void help(TreeNode root) {
        if (root == null) return;
        help(root.left);
        if (pre == null) {
            count = 1;
        } else if (pre == root.val) {
            count++;
        } else {
            count = 1;
        }
        if (count == maxcount) {
            list.add(root.val);
        }
        if (count > maxcount) {
            maxcount = count;
            list.clear();
            list.add(root.val);
        }
        pre = root.val;
        help(root.right);
    }

    void help1(TreeNode root) {
        if (root == null) return;
        help1(root.left);
        if (pre == Integer.MAX_VALUE) count++;
        else if (pre == root.val) {
            count++;
        }else count = 1;
        if (maxcount == count) set.add(root.val);
        if(count>maxcount){
            maxcount=count;
            set.clear();
            set.add(root.val);
        }
        pre = root.val;
        help1(root.right);
    }
}

package com.company.回溯;

import com.company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-17 19:25
 */
public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        new 二叉树中和为某一值的路径().pathSum(TreeNode.geneTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}),27);

    }
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    int sum=0;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        back(root,target);
        System.out.println(res);
        return res;
    }
    void back(TreeNode root,int target){
        sum+=root.val;
        path.add(root.val);
        if (root.left==null&&root.right==null&&sum==target) res.add(new ArrayList<>(path));
        if (root.left!=null) back(root.left,target);
        if (root.right!=null) back(root.right,target);
        path.removeLast();
        sum-=root.val;
    }
}

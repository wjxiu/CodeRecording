package com.company.二叉树.路径;

import com.company.公共类.TreeNode;

import java.util.ArrayList;

/**
 * @author xiu
 * @create 2023-10-25 18:51
 */
public class 求和路径 {
    public static void main(String[] args) {
        System.out.println(pathSum(TreeNode.geneTree(1), 1));
    }
   static int res=0;
    public static int pathSum(TreeNode root, int sum) {
        if (root==null)return 0;
        back(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }
   static void back(TreeNode root,int sum){
        if (root==null)return;
        sum-=root.val;
        if (sum==0){
            res+=1;
        }
        back(root.left, sum);
        back(root.right, sum);
    }
}

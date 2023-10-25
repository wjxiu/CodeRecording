package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-16 15:32
 */
public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        System.out.println((1<<31)-1);
        System.out.println(new 将有序数组转换为二叉搜索树().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return  build(nums,0,nums.length-1);
    }
    //左闭右闭
    TreeNode build(int[] nums,int left,int right) {
        if(left>right) return null;
        int midindex= (right+left)/2;
        int mid=nums[midindex];
        TreeNode root=new TreeNode(mid);
        root.left=build(nums,left,midindex-1);
        root.right=build(nums,midindex+1,right);
        return root;
    }

    TreeNode sortedArrayToBST1(int[] nums) {
        return help1(nums,0, nums.length-1);
    }

    TreeNode help1(int[] nums,int left,int right){
        if (left>right)return null;
        int mid=(left+right)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left=help1(nums, mid+1, right);
        treeNode.right=help1(nums, left,mid-1);
        return treeNode;
    }
}

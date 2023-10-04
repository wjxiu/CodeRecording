package com.company.二叉树;
import com.company.公共类.TreeNode;
/**
 * @author xiu
 * @create 2023-09-03 7:37
 */
public class 最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
     return  help(nums,0, nums.length-1);
    }

    private TreeNode help(int[] nums,int left,int right){
        if (left>right||left<0||right> nums.length-1)return null;
        int mid= (left+right)/2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left=help(nums,left,mid-1);
        head.right=help(nums,mid+1,right);
        return head;
    }
}

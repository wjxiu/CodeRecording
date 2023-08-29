package company.二叉树;

import company.公共类.TreeNode;

import java.util.ArrayList;

/**
 * @author xiu
 * @create 2023-07-15 13:51
 */
public class 最大二叉树 {
    public static void main(String[] args) {
        System.out.println(new 最大二叉树().constructMaximumBinaryTree(new int[]{3, 2, 1}));
        System.out.println();
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length==1) return new TreeNode(nums[0]);
        return help1(nums, 0, nums.length-1);
    }

    public TreeNode help(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        if (rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);
        int maxval = leftIndex;
        int maxindex = nums[leftIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxval) {
                maxindex = i;
                maxval = nums[i];
            }
        }
//        左闭右开区间
        TreeNode root = new TreeNode(maxval);
        root.left = help(nums, leftIndex, maxindex);
        root.right = help(nums, maxindex + 1, rightIndex);
        return root;
    }

//左闭右闭
    public TreeNode help1(int[] nums, int left, int right) {
        if (left>right) return null;
        if (left==right) return new TreeNode(nums[left]);
        int max = Integer.MIN_VALUE;
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = help1(nums, left, maxIndex - 1);
        root.right = help1(nums, maxIndex+1,  right);
        return root;
    }

}

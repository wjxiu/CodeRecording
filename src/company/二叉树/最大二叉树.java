package company.二叉树;

import company.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 13:51
 */
public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums,0,nums.length);
    }

    public TreeNode help(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex-leftIndex<1){
            return null;
        }
        if (rightIndex-leftIndex==1) return new TreeNode(nums[leftIndex]);
        int maxval=leftIndex;
        int maxindex=nums[leftIndex];
        for (int i = leftIndex+1; i < rightIndex; i++) {
            if (nums[i]>maxval){
                maxindex=i;
                maxval=nums[i];
            }
        }
//        左闭右开区间
        TreeNode root = new TreeNode(maxval);
        root.left=help(nums, leftIndex, maxindex);
        root.right=help(nums,maxindex+1,rightIndex);
        return root;
    }
}

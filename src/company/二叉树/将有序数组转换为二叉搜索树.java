package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-16 15:32
 */
public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        new 将有序数组转换为二叉搜索树().sortedArrayToBST(new int[]{-10,-3,0,5,9});
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
}

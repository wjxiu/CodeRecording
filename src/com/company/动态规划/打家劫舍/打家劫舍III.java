package company.动态规划.打家劫舍;

import company.公共类.TreeNode;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 11:36
 */
public class 打家劫舍III {
    public static void main(String[] args) {
        System.out.println(new 打家劫舍III().rob1(TreeNode.geneTree(4,1,null,2,null,3)));
    }
    public int rob(TreeNode root) {
        int[] ints = rotTree(root);
        System.out.println(Arrays.toString(ints));
        return Math.max(ints[0],ints[1] );
    }
    int[] rotTree(TreeNode root){
//        记录偷root和不偷root的最大价值
//        dp[0]不偷，dp[1]偷
        int[]dp=new int[2];
        if(root==null) return dp;
        int[] left = rotTree(root.left);
        int[] right = rotTree(root.left);
        dp[1]=root.val+left[0]+right[0];
        dp[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return dp;
    }
    public int rob1(TreeNode root){
        int[] ints = rotTree1(root);
        System.out.println(Arrays.toString(ints));

        return Math.max(ints[0],ints[1]);
    }

    int[] rotTree1(TreeNode root){
        if (root==null) return new int[]{0,0};
        int[] left = rotTree1(root.left);
        int[] right = rotTree1(root.right);
//        偷父节点
        int robroot=root.val+left[0]+right[0];
//        不偷父节点
        int max=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{max,robroot};
    }
}

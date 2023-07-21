package company.动态规划.打家劫舍;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-21 11:36
 */
public class 打家劫舍III {
    public int rob(TreeNode root) {
        int[] ints = rotTree(root);
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
}

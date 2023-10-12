package com.company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-22 22:05
 */
public class 不相交的线 {
    public static void main(String[] args) {
        int[] num=new int[]{1,4,2};
        int[] num1=new int[]{1,2,4};
//        System.out.println(new 不相交的线().maxUncrossedLines1(num, num1));
        System.out.println(new 不相交的线().maxUncrossedLines2(num, num1));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+2][nums2.length+2];
        int res=0;
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;i++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
                res=Math.max(dp[i][j],res);
            }
        }
        return res;
    }


    public int maxUncrossedLines1(int[] nums1, int[] nums2){
        int res=0;
//        dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1]==nums2[j-1]) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                res=Math.max(res,dp[i][j]);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return res;
    }

    public int maxUncrossedLines2(int[] nums1, int[] nums2){
        int m=nums1.length;int n=nums2.length;
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}

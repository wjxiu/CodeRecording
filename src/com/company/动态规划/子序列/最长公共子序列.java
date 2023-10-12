package com.company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-08-06 14:55
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        System.out.println(new 最长公共子序列().longestCommonSubsequence1("a", ""));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        int max=Integer.MIN_VALUE;
        for (int i = 1; i <=text1.length(); i++) {
            for (int j = 1; j <=text2.length() ; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max=Math.max(max,dp[i][j]);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return max;
    }

    public int longestCommonSubsequence1(String text1, String text2){
        int m = text1.length();
        int n =text2.length();
        int[][] dp=new int[m +1][n +1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[m][n];
    }
}

package com.company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-23 10:47
 */
public class 不同的子序列 {
    public static void main(String[] args) {
//        System.out.println(new 不同的子序列().numDistinct("rabbbit", "rabit"));
//        System.out.println("----------");
        System.out.println(new 不同的子序列().numDistinct1("rabbbit", "rabit"));
        System.out.println(new 不同的子序列().numDistinct2("rabbbit", "rabbit"));
    }
    public  int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for (int j = 0; j < t.length(); j++) {
            dp[0][j]=0;
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][0]=1;
        }
        dp[0][0]=1;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[s.length()][t.length()];
    }


    public  int numDistinct1(String s, String t){
        int[][] dp=new int[s.length()+1][t.length()+1];
        for (int i = 0; i <s.length(); i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < t.length()+1; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[s.length()][t.length()];
    }
//dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
    public  int numDistinct2(String s, String t){
        int[][] dp=new int[s.length()+1][t.length()+1];
        for (int i = 0; i <=s.length(); i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < t.length()+1; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}

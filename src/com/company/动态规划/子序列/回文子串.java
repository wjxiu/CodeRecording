package com.company.动态规划.子序列;

/**
 * @author xiu
 * @create 2023-07-24 14:16
 */
public class 回文子串 {
    public static void main(String[] args) {
        System.out.println(new 回文子串().countSubstrings("qqqqqqq"));
    }
    public int countSubstrings(String s) {
        int res=0;
//        布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        boolean[][] dp=new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >=0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else{
                    if (Math.abs(i-j)<=1){
                        res++;
                        dp[i][j]=true;
                    }else if(dp[i+1][j-1]){
                        dp[i][j]=true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}

package company.动态规划.子序列;

import jdk.jfr.internal.tool.Main;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-24 14:36
 */
public class 最长回文子序列 {
    public static void main(String[] args) {
        System.out.println(new 最长回文子序列().longestPalindromeSubseq("bbbab"));
    }
    public int longestPalindromeSubseq(String s) {
//        dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
        int[][] dp=new int[s.length()][s.length()];
        for (int i = 0; i <s.length(); i++) {
            dp[i][i]=1;
        }
        for (int i = s.length()-1; i >=0; i--) {
            for (int j = i+1; j <s.length(); j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

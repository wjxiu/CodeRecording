package company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-23 22:40
 */
public class 两个字符串的删除操作 {
    public static void main(String[] args) {
//        System.out.println(new 两个字符串的删除操作().minDistance("sea", "eat"));
        System.out.println(new 两个字符串的删除操作().minDistance1("leetcode", "etco"));
    }
    public int minDistance(String word1, String word2) {
//        dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <=word1.length(); i++) dp[i][0]=i;
        for (int j = 0; j <=word2.length(); j++) dp[0][j]=j;
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length() ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+2));
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[word1.length()][word2.length()];
    }

    public int minDistance1(String word1, String word2){
        int[][] dp=new int[word1.length()+1][word2.length()+1];
//      不等  dp ij   min （i,j-1 +1） （i-1,j +1) (j-1,i-1 +2)
//        相等        i-1,j-1
        for (int i = 0; i < word2.length()+1; i++) dp[0][i]=i;
        for (int i = 0; i < word1.length()+1; i++) dp[i][0]=i;
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length(); j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i][j-1]+1,Math.min(dp[i-1][j]+1,dp[i-1][j-1]+2));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

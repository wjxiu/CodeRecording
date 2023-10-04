package com.company.动态规划.股票问题;

import com.company.公共类.工具类.LeetCodeUtils;

/**
 * @author xiu
 * @create 2023-07-21 14:32
 */
public class 买卖股票的最佳时机2 {
    public static void main(String[] args) {
        System.out.println(new 买卖股票的最佳时机2().maxProfit1(LeetCodeUtils.geneIntArr("[7,1,5,3,6,4]")));
    }
    public int maxProfit(int[] prices) {
//        dp[i][0]表示持有股票的最大金钱
//        dp[i][1]表示不持有股票
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }


    public int maxProfit1(int[] prices){
        int[][] dp=new int[prices.length][2];
        dp[0][1]=-prices[0];
//        0未持有
//        1持有
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }
}

package com.company.动态规划.股票问题;

/**
 * @author xiu
 * @create 2023-08-06 12:15
 */
public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int fee,int[] prices) {
        int[][] dp=new int[prices.length][2];
        dp[0][1]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][1]+prices[i]-fee,dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }
}

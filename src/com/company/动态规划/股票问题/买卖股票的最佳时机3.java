package com.company.动态规划.股票问题;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 14:48
 */
public class 买卖股票的最佳时机3 {
    public static void main(String[] args) {
        System.out.println(new 买卖股票的最佳时机3().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new 买卖股票的最佳时机3().maxProfit1(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][5];
        //没有操作 （其实我们也可以不设置这个状态）
        dp[0][0]=0;
        //第一次持有股票
        dp[0][1]=-prices[0];
        //第一次不持有股票
        dp[0][2]=0;
        //第二次持有股票
        dp[0][3]=-prices[0];
        //第二次不持有股票
        dp[0][4]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[prices.length-1][4];
    }

    public int maxProfit1(int[] prices){
//        0:未持有 1第一次持有 2 第一次持有后卖掉 3第二次持有 4 第二次持有后卖掉
        int[][] dp=new int[prices.length][5];
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i-1][1]+prices[i],dp[i-1][2]);
            dp[i][3]=Math.max(dp[i-1][2]-prices[i],dp[i-1][3]);
            dp[i][4]=Math.max(dp[i-1][3]+prices[i],dp[i-1][4]);
        }
        return dp[prices.length-1][4];
    }
}

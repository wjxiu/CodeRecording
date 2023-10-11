package com.company.动态规划.股票问题;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 14:02
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(new 买卖股票的最佳时机().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new 买卖股票的最佳时机().maxProfit1(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
//        dp[i][0]表示持有股票的最大金钱
//        dp[i][1]表示不持有股票
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }



    public int maxProfit1(int[] prices){
        int[][] dp=new int[prices.length][2];
//        不持有股票，手里的钱
        dp[0][0]=0;
//        持有持有
        dp[0][1]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
//            卖股票 现在卖掉 之前卖掉了
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
//            买股票 现在买，之前已经买到了
//            只能买一次，所以买之前的现金是0，买了之后现金就是-prices[i]
            dp[i][1]=Math.max(-prices[i],dp[i-1][1]);
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[prices.length-1][0];
    }
}

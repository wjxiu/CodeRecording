package com.company.动态规划.背包问题.完全背包;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-20 23:49
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        System.out.println(new 零钱兑换().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new 零钱兑换().coinChange1(new int[]{2}, 5));
    }
    public long coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                if (dp[j-coins[i]]!= max){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==max?-1:dp[amount];
    }


    public long coinChange1(int[] coins, int amount){
        int[] dp=new int[amount+1];
        int max=Integer.MAX_VALUE;
        Arrays.fill(dp,max);
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <=amount; j++) {
                if (j>=coins[i]&&dp[j-coins[i]]!=max)
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount]==max?-1:dp[amount];
    }
}

package com.company.动态规划.背包问题.完全背包;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-20 20:13
 */

public class 零钱兑换II {
    public static void main(String[] args) {
//        System.out.println(new 零钱兑换II().change(5, new int[]{1, 2, 5}));
        System.out.println(new 零钱兑换II().change2(5, new int[]{1, 2, 5}));
//        System.out.println(new 零钱兑换II().change1(3, new int[]{4}));
    }
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
//        dp[j]=dp[j-coin[i]]
        dp[0]=1;
//        求组合
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                    dp[j]+=dp[j-coins[i]];
            }
        }
//        求排序
//        for (int i = 0; i < amount+1; i++) {
//            for (int j = 0; j < coins.length; j++)
//            if (i>=coins[j]){
//                dp[i]+=dp[i-coins[j]];
//            }
//            System.out.println(Arrays.toString(dp));
//        }
        return dp[amount];
    }


    public int change1(int amount, int[] coins){
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                dp[j]+=dp[j-coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println("----------------");
        dp=new int[amount+1];
        dp[0]=1;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }


        return dp[amount];
    }



    public int change2(int amount, int[] coins){
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=coins.length-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                if(j>=coins[i]) dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];
    }
}

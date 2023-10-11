package com.company.动态规划.背包问题.KnapsackProblem;

import java.util.Arrays;

/**
 * 回溯01背包
 *
 * @author xiu
 * @create 2023-10-07 15:14
 */
public class pack {
    int sum = 0;
    int res = 0;
    int pound = 0;
    boolean[] used;

    public static void main(String[] args) {
        System.out.println(new pack().soulve(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4));

    }

    public int soulve(int[] weight, int[] value, int max) {
//       used=new boolean[weight.length];
//       back(weight,value,max);

//       return res;
        return dp2(weight, value, max);
    }

    void back(int[] weight, int[] value, int max) {
        for (int i = 0; i < weight.length; i++) {
            if (used[i]) continue;
            if (max >= pound + weight[i]) sum += value[i];
            else continue;
            pound += weight[i];
            used[i] = true;
            res = Math.max(sum, res);
            back(weight, value, max);
            pound -= weight[i];
            used[i] = false;
            sum -= value[i];
        }
    }

    //   i是货物，j是重量
    int[][] dp = null;

    //   二维dp
    int dp(int[] weight, int[] value, int max) {
        dp = new int[weight.length][max + 1];
        for (int i = 0; i <= max; i++)
            if (weight[0] <= i) dp[0][i] = value[0];
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= max; j++) {
                if (j >= weight[i]) dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[weight.length - 1][max];
    }

    //   一维dp
    int dp2(int[] weight, int[] value, int max) {
//        dp[i]=容量i装入的最大物品
        int[] dp=new int[max+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j =max; j>=1; j--) {
                if (j>=weight[i])
                    dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
//        先遍历背包再遍历物品，这是错的，
//        dp数组：
//          [0, 0, 0, 0, 30]
//          [0, 0, 0, 20, 30]
//          [0, 0, 15, 20, 30]
//          [0, 15, 15, 20, 30]
//        for (int j =max; j>=1; j--) {
//            for (int i = 0; i < weight.length&&j-weight[i]>=0; i++) {
//               dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
//            }
//            System.out.println(Arrays.toString(dp));
//        }
        return dp[max];
    }
}

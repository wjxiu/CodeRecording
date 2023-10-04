package com.company.动态规划;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-19 21:12
 */
public class 整数拆分 {
    public static void main(String[] args) {
        整数拆分 temp = new 整数拆分();
        for (int i = 2; i <=50; i++) {

            int i1 = temp.integerBreak1(i);
            int i2 = temp.integerBreak(i);
            System.out.println(i1==i2);
        }
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <=n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }

    public int integerBreak1(int n){
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        if(n==3) return 2;
        for (int i = 3; i <=n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
            }
        }
        return dp[n];
    }
}

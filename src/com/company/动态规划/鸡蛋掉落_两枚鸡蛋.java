package com.company.动态规划;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-19 19:36
 */
public class 鸡蛋掉落_两枚鸡蛋 {
    public static void main(String[] args) {
        System.out.println(twoEggDrop(100));
    }
    static int twoEggDrop(int n) {
        Integer[][] dp=new Integer[2][n+1];
        Arrays.fill(dp[1], Integer.MAX_VALUE-1);
        for (int i = 1; i <=n; i++) {
            dp[0][i]=i;
        }
        dp[0][0] =0; dp[1][0] = 0;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i; j++) {
                dp[1][i]=Math.min(dp[0][j-1],dp[1][i-j])+1;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[1][n];
    }
}

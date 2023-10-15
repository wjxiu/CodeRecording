package com.company.动态规划.概率;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-13 19:10
 */
public class 新21点 {
//    输入：n = 21, k = 17, maxPts = 10
//输出：0.73278
    public static void main(String[] args) {
        System.out.println(new21Game(21, 17, 10));
    }
    public static double new21Game(int n, int k, int maxPts) {
        double[] dp=new double[maxPts+n+1];
        for (int i = k; i <=n; i++) dp[i]=1;

        for (int i =k-1; i>=0 ; i--) {
            for (int j = i; j <=maxPts+i; j++) {
                dp[i]+=dp[j];
            }
            dp[i]=dp[i]/maxPts;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
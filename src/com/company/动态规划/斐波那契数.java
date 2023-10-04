package com.company.动态规划;

import java.util.Arrays;

/**
 * 确定dp数组（dp table）以及下标的含义 ：第i项斐波那契数列
 * 确定递推公式  dp[i]=dp[i-2]+dp[i-1]
 * dp数组如何初始化 dp[0]=0; dp[1]=1;
 * 确定遍历顺序 2-n
 * 举例推导dp数组
 * @author xiu
 * @create 2023-07-19 18:54
 */
public class 斐波那契数 {
    public static void main(String[] args) {
        System.out.println(new 斐波那契数().fib(6));
    }
    public int fib(int n) {
        if (n<2)return n;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        int a=0;
        int b=1;
        int c=0;
//      递推公式  dp[i]=dp[i-2]+dp[i-1]
        for (int i = 2; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
            c=a+b;
            a=b;
            b=c;
            System.out.println(c);
        }
        return c;
    }
}

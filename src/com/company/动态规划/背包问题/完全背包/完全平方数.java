package company.动态规划.背包问题.完全背包;

import java.util.Arrays;

/**
 *   dp[i] 和为i的完全平方数的最少数量为dp[i]
 *   递推公式：dp[i]=min(dp[i],dp[i-j*j]+1)
 *   初始化: dp[0]=0; Arrays.fill(dp,Integer.MAX_VALUE-2);
 *   遍历顺序：都行
 * @author xiu
 * @create 2023-07-21 10:04
 */
public class 完全平方数 {
    public static void main(String[] args) {
        System.out.println(new 完全平方数().numSquares(7));
        System.out.println("-----------------------");
        System.out.println(new 完全平方数().numSquares1(7));
    }
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE-2);
        dp[1]=1;
        dp[0]=0;
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j*j<=n; j++) {
                if (i >= j*j) {
                    dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }


    public int numSquares1(int n){
        int[] dp=new int[n+1];
        int maxValue = Integer.MAX_VALUE;
        Arrays.fill(dp, maxValue);
        dp[0]=0;
        for (int i = 1; i*i < n; i++) {
            for (int j = 0; j <=n; j++) {
                if (j>=i*i&&dp[j-i*i]!= maxValue)
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n]==maxValue?1:dp[n];
    }
}

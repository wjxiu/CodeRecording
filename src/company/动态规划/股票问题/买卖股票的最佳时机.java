package company.动态规划.股票问题;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 14:02
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        new 买卖股票的最佳时机().maxProfit(new int[]{7,6,4,3,1});
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
        System.out.println(Arrays.deepToString(dp));
        return dp[prices.length-1][1];
    }
}

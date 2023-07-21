package company.动态规划.股票问题;

/**
 * @author xiu
 * @create 2023-07-21 14:32
 */
public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
//        dp[i][0]表示持有股票的最大金钱
//        dp[i][1]表示不持有股票
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}

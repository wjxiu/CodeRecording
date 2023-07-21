package company.动态规划.股票问题;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 15:04
 */
public class 买卖股票的最佳时机4 {
    public static void main(String[] args) {
        System.out.println(new 买卖股票的最佳时机4().maxProfit(2,new int[]{3,2,6,5,0,3}));
    }
    public int maxProfit(int k,int[] prices) {
        int length = prices.length;
        int[][] dp=new int[length][k*2+1];
        for (int i = 1; i < k*2; i+=2) {
            dp[0][i]=-prices[0];
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <k*2; j+=2) {
                dp[i][j+1]=Math.max(dp[i-1][j+1],dp[i-1][j]-prices[i]);
                dp[i][j+2]=Math.max(dp[i-1][j+2],dp[i-1][j+1]+prices[i]);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[length -1][k*2];
    }
}

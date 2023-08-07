package company.动态规划.股票问题;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 15:04
 */
public class 买卖股票的最佳时机4 {
    public static void main(String[] args) {
        System.out.println(new 买卖股票的最佳时机4().maxProfit(2,new int[]{3,2,6,5,0,3}));
        System.out.println(new 买卖股票的最佳时机4().maxProfit1(2,new int[]{3,2,6,5,0,3}));
    }
    public int maxProfit(int k,int[] prices) {
        int length = prices.length;
        int[][] dp=new int[length][k*2+1];
        for (int i = 1; i < k*2; i+=2) {
            dp[0][i]=-prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <k*2; j+=2) {
                dp[i][j+1]=Math.max(dp[i-1][j+1],dp[i-1][j]-prices[i]);
                dp[i][j+2]=Math.max(dp[i-1][j+2],dp[i-1][j+1]+prices[i]);
            }
        }
        return dp[length -1][k*2];
    }

    public int maxProfit1(int k,int[] prices){
        int[][] dp=new int[prices.length][2*k+1];
//        偶数 未持有，奇数持有
        for (int i = 1; i <2*k+1; i+=2) {
             dp[0][i]=-prices[0];
        }
        for (int i = 1; i < prices.length ; i++) {
            for (int j = 1; j <2*k+1; j++) {
                if (j%2==0){
                    dp[i][j]=Math.max(dp[i-1][j-1]+prices[i],dp[i-1][j]);
                }else{
                    dp[i][j]=Math.max(dp[i-1][j-1]-prices[i],dp[i-1][j]);
                }
            }
        }
        return dp[prices.length-1][2*k];
    }
}

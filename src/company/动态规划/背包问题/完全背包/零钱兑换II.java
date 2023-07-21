package company.动态规划.背包问题.完全背包;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-20 20:13
 */

public class 零钱兑换II {
    public static void main(String[] args) {
        System.out.println(new 零钱兑换II().change(5, new int[]{1, 2, 5}));
    }
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
//        dp[j]=dp[j-coin[i]]
        dp[0]=1;
//        求组合
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                    dp[j]+=dp[j-coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println("-------------------");
//        求排序
//        for (int i = 0; i < amount+1; i++) {
//            for (int j = 0; j < coins.length; j++)
//            if (i>=coins[j]){
//                dp[i]+=dp[i-coins[j]];
//            }
//            System.out.println(Arrays.toString(dp));
//        }
        return dp[amount];
    }
}

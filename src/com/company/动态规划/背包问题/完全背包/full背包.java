package company.动态规划.背包问题.完全背包;

/**
 * @author xiu
 * @create 2023-08-05 12:32
 */
public class full背包 {
    void full(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
    }
}

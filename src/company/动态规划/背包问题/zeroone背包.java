package company.动态规划.背包问题;

import java.util.Arrays;

/**
 * Dp ij = 0-i物品 j重量的最大价值
 * Dp ij =max{dp [i-1][ j],
 * Value[i]+dp[i-1][j-weight[i]] }
 * 01背包问题
 *
 * @author xiu
 * @create 2023-07-20 10:07
 */
public class zeroone背包 {
    public static void main(String[] args) {
        System.out.println(new zeroone背包().maxvalue1(new int[]{15, 20, 30}, new int[]{1, 3, 4}, 4));
    }

    //    二维dp数组解法
    public int maxvalue(int[] value, int[] weight, int capcity) {
        int[][] dp = new int[value.length][capcity + 1];
        for (int i = weight[0]; i < dp[0].length; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= capcity; j++) {
                System.out.println(Arrays.deepToString(dp));
                if (j < weight[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
//    1维dp数组解法
    public int maxvalue1(int[] value, int[] weight, int capcity) {
        int[] dp=new int[capcity+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = capcity; j >=weight[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[capcity];
    }
}

package company.动态规划.背包问题.KnapsackProblem;
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
        System.out.println(new zeroone背包().maxvalue3(new int[]{15, 20, 30}, new int[]{1, 3, 4}, 4));
    }

    //    二维dp数组解法
    public int maxvalue(int[] value, int[] weight, int capcity) {
        int[][] dp = new int[value.length][capcity + 1];
        for (int i = weight[0]; i < dp[0].length; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= capcity; j++) {
                if (j < weight[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    public int maxvalue1(int[] value, int[] weight, int capcity){
        int[][]dp=new int[weight.length][capcity+1];
        for (int i = 1; i < capcity+1; i++) if (weight[0]<=i) dp[0][i]=value[0];
        for (int i = 1; i <weight.length ; i++) {
            for (int j = 1; j < capcity+1; j++) {
                if (j<weight[i]) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
            }
        }
        return dp[weight.length-1][capcity];
    }
//    1维dp数组解法
    public int maxvalue2(int[] value, int[] weight, int capcity) {
        int[] dp=new int[capcity+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = capcity; j >=weight[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[capcity];
    }
    public int maxvalue3(int[] value, int[] weight, int capcity){
        //dp[j] 容量为j的背包，所背的物品价值可以最大为dp[j]
        int[] dp=new int[capcity+1];
        for (int i = 0; i < weight.length; i++) {
//            遍历背包顺序要逆序遍历，因为需要之前的dp[j-weight[i]]的值，逆序遍历保证不被覆盖
            for (int j = capcity; j >=0 ; j--) {
                if (j>=weight[i]){
                    dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
                }

            }
            System.out.println(Arrays.toString(dp));
        }
//        遍历背包，再遍历物品这样是错的
//        for (int i = capcity; i>=0 ; i--) {
//            for (int j = 0; j < weight.length; j++) {
//                if (i>=weight[j]){
////                    原因在于dp[i-weight[j]]+value[j] 和dp[i]取最大值，前者是在dp[i]左边的，初始化是0，所以第一次遍历完物品之后只会放入一个物品
//                    dp[i]=Math.max(dp[i],dp[i-weight[j]]+value[j]);
//                }
//            }
//            System.out.println(Arrays.toString(dp));
//        }
        return dp[capcity];
    }
}

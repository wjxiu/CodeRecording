package company.动态规划.背包问题.KnapsackProblem;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author xiu
 * @create 2023-07-20 12:37
 */
public class 最后一块石头的重量2 {
    public static void main(String[] args) {
        System.out.println(new 最后一块石头的重量2().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new 最后一块石头的重量2().lastStoneWeight2(new int[]{2, 7, 4, 1, 8, 1}));
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = IntStream.of(stones).sum();
        int half = sum / 2;
        int[] dp=new int[half+1];
        for (int i = 0; i <stones.length; i++) {
            for (int j = half; j >=stones[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-dp[half]-dp[half];
    }

    public int lastStoneWeight2(int[] stones){
        int sum = Arrays.stream(stones).sum();
        System.out.println(sum);
        int half = sum / 2;
        int[] dp = new int[half+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = half; j>=stones[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum- dp[half]*2;
    }
}

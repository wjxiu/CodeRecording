package com.company.动态规划.背包问题.KnapsackProblem;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author xiu
 * @create 2023-07-20 11:06
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        System.out.println(new 分割等和子集().test(new int[]{1, 5, 11, 5}));
        System.out.println(new 分割等和子集().canPartition1(new int[]{1, 2, 3, 5}));
    }

    //    相当于01背包的的重量只有一半，物品的重量和价值都是nums[i]
    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        int half = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }
        //dp[i]表示重量为i的背包装入的价值最大为dp[i],这里需要sum/2大小的背包
        int[] dp = new int[half + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[half] == half;
    }

    public boolean test(int[] nums) {
        int sum = IntStream.of(nums).sum();
        int half = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }
//        dp[j] :容量为j 保存nums的元素的和
        int[] dp = new int[half + 1];
//        
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >=nums[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[half]==half;
    }

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int half = sum / 2;
        if (sum %2==1) return false;
        int[] dp=new int[half+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j>=nums[i] ; j--) {
                    dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[half]== half;
    }
}

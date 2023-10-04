package com.company.动态规划.背包问题.完全背包;

/**
 * @author xiu
 * @create 2023-07-20 21:10
 */
public class 组合总和Ⅳ {
    public static void main(String[] args) {
        System.out.println(new 组合总和Ⅳ().combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(new 组合总和Ⅳ().combinationSum4_1(new int[]{1, 2, 3}, 4));
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
//        求排序
//        先遍历背包，再遍历物品
        for (int i = 0; i <=target; i++) {
            for (int j =0; j < nums.length; j++) {
                if (i>=nums[j]){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
    public int combinationSum4_1(int[] nums, int target){
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i = 1; i <=target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i>=nums[j]) dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}

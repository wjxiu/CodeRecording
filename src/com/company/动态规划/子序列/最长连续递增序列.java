package com.company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 22:15
 */
public class 最长连续递增序列 {
    public static void main(String[] args) {
        System.out.println(new 最长连续递增序列().findLengthOfLCIS2(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new 最长连续递增序列().findLengthOfLCIS2(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new 最长连续递增序列().findLengthOfLCIS2(new int[]{1, 3, 5, 4, 7}));
    }
    public int findLengthOfLCIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            res=Math.max(res,dp[i]);
            System.out.println(Arrays.toString(dp));
        }
        return res;
    }


    public int findLengthOfLCIS1(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]) dp[i]=dp[i-1]+1;
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public int findLengthOfLCIS2(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

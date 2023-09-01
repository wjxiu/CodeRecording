package com.company.数组;

import java.util.TreeSet;

/**
 * @author xiu
 * @create 2023-08-31 22:06
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {

    }
    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y); y = x;
    }
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        int max=nums[0];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-1],nums[i]);
            max=Math.max(dp[i],max);
        }
        return max;
    }
}

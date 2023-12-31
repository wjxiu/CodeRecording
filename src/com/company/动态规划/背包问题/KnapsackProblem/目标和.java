package com.company.动态规划.背包问题.KnapsackProblem;

import java.util.Arrays;

/**
 * 动态规划不会，这是回溯的解法
 * @author xiu
 * @create 2023-07-20 12:56
 */
public class 目标和 {
    int count = 0;

    public static void main(String[] args) {
        System.out.println(new 目标和().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        back(nums, target, 0, 0);
        return count;
    }

    public void back(int[] nums, int target, int start, int sum) {
        if (start == nums.length) {
            if (sum == target) count++;
        } else {
            back(nums, target, start + 1, sum + nums[start]);
            back(nums, target, start + 1, sum - nums[start]);
        }
    }
//    推导过程
    // 假设正数字和为L,负数和为R,nums的和为sum，以下为推导过程
    // L+R=target;R=target-L; L-R=sum;L-(tar-L)=sum;L=(sum+tar)/2
    // 所以问题就转换为求L的个数
    // dp[i]定义：表达式结果为i的方法个数
    //dp[5]=dp[5-1]+dp[5-2]+dp[5-3]+...dp[5-nums[i]](前提是5>=nums[i])
    // 所以可以推出公式为：dp[j]+=dp[j-nums[i]]
//    dp
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target)>sum) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;//求出需要凑成target 的nums的正数个数
        if(size < 0) size = -size;
//        dp[j]：装满容量为J的方法
        int[] dp=new int[size+1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >=nums[i] ; j--) {
                dp[j]+=dp[j-nums[i]];//也不太懂
            }
        }
        return dp[size];
    }
}

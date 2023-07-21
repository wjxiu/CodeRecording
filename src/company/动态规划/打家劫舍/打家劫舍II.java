package company.动态规划.打家劫舍;

import jdk.jfr.internal.tool.Main;

import java.util.UnknownFormatConversionException;

/**
 * @author xiu
 * @create 2023-07-21 11:04
 */
public class 打家劫舍II {
    public static void main(String[] args) {
        System.out.println(new 打家劫舍II().rob(new int[]{1,2,1,1}));
    }
    public int rob(int[] nums) {

//        分为两种情况
//        选择头+中间，不选择尾
//        选择中间+尾，不选择头
        int help = help(nums, 0, nums.length - 2);
        int help1 = help(nums, 1, nums.length - 1);
        return Math.max(help,help1);
    }
    int help(int[] nums,int start,int end){
        if (start==end) return nums[start];
        if (end-start==1) return Math.max(nums[start],nums[end]);
        int[] dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}

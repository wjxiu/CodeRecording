package company.动态规划.打家劫舍;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 10:55
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        System.out.println(new 打家劫舍().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new 打家劫舍().rob1(new int[]{0}));
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
//        dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i <nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            System.out.println(Arrays.toString(dp));
        }
        return dp[nums.length-1];
    }


    public int rob1(int[] nums){
        if (nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }


}

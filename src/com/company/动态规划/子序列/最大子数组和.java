package company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-22 22:08
 */
public class 最大子数组和 {
    public static void main(String[] args) {
//        System.out.println(new 最大子数组和().maxSubArray1(new int[]{-2, 1, -2, 4, 3, 5, 6, 1, 5}));
//        System.out.println(new 最大子数组和().maxSubArray2(new int[]{-2, 1, -2, 4, 3, 5, 6, 1, 5}));
        System.out.println(new 最大子数组和().maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    //    dp
    public int maxSubArray(int[] nums) {
//        dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i = 1; i < nums.length ; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
            System.out.println(Arrays.toString(dp));
        }
        return max;
    }


    public int maxSubArray1(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int res=-1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(dp[i],res);
        }
        return res;
    }


    //    贪心思路
    public int maxSubArray2(int[] nums) {
        int count =nums[0];
        int sum=count;
        for (int i = 1; i < nums.length; i++) {
            if (count <0){
                count =nums[i];
            }else{
                count +=nums[i];
            }
            sum=Math.max(sum,count);
        }
        return sum ;
    }

    public int maxSubArray3(int[] nums){
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i = 1; i < nums.length; i++) {
                dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
                max=Math.max(dp[i],max);
        }
        return max;
    }

}

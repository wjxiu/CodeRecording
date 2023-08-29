package company.贪心;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-08-01 14:52
 */
public class 最大子序和 {
    public static void main(String[] args) {
        System.out.println(new 最大子序和().maxSubArray(new int[]{-2, 1, -2, 4, 3, 5, 6, 1, 5}));
        System.out.println(new 最大子序和().maxSubArray1(new int[]{-2, 1, -2, 4, 3, 5, 6, 1, 5}));
//        System.out.println(new 最大子序和().maxSubArray2(new int[]{-2, 1, -2, 4, 3, 5, 6, 1, 5}));
//        System.out.println(new 最大子序和().maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum=Math.max(sum+nums[i],nums[i]);
//            System.out.println(sum);
            res=Math.max(res,sum);
        }
        return res;
    }
    public int maxSubArray1(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        int res=dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(dp[i],res);
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        int sum=Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(-prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }
        return dp[prices.length-1][0];
     }


//    public int maxSubArray2(int[] nums){
//
//    }

}

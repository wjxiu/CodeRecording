package company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 15:45
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        int[] nums1=new int[]{3,2,1};
        System.out.println(new 最长递增子序列().lengthOfLIS(nums1));
        System.out.println("===================");
        System.out.println(new 最长递增子序列().lengthOfLIS1(nums1));
    }
    public int lengthOfLIS(int[] nums) {
//        dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
        int[] dp=new int[nums.length];
        int ans=1;
        Arrays.fill(dp,1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                ans=Math.max(ans,dp[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return ans;
    }



    public int lengthOfLIS1(int[] nums){
        if (nums.length==1) return 1;
        int[]dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                res=Math.max(dp[i],res);
            }
            System.out.println(Arrays.toString(dp));
        }
        return res;
    }
}

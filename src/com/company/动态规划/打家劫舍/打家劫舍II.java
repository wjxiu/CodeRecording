package com.company.动态规划.打家劫舍;


import com.company.公共类.TreeNode;

import java.util.Arrays;
import java.util.UnknownFormatConversionException;

/**
 * @author xiu
 * @create 2023-07-21 11:04
 */
public class 打家劫舍II {
    public static void main(String[] args) {
        System.out.println(new 打家劫舍II().rob2(new int[]{1,2,1,1}));
        System.out.println(new 打家劫舍II().rob2(new int[]{0}));
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



    public int rob1(int[] nums){
        if (nums.length==1) return nums[0];
        int[] ints = Arrays.copyOf(nums, nums.length - 1);
        int[] ints1 = Arrays.copyOfRange(nums, 1, nums.length);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
        int robhelp = robhelp(ints);
        int robhelp1 = robhelp(ints1);
        return Math.max(robhelp,robhelp1);
    }

    public int robhelp(int[] nums){
        if (nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }


    public int rob2(int[] nums) {
        if (nums.length==1) return nums[0];
        int[] house1 = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] house2 = Arrays.copyOfRange(nums, 1, nums.length);
        int help = help(house1);
        int help1 = help(house2);
        return Math.max(help,help1);
    }
    private int help(int[] house){

        if (house.length==1)return house[0];
        if (house.length==2)return Math.max(house[0],house[1]);
        int[] dp=new int[house.length];dp[0]=house[0];dp[1]=Math.max(house[0],house[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+house[i]);
        }
        return dp[house.length-1];
    }
    public int[] help(TreeNode root){
        int[] dp=new int[2];
        if(root==null) return dp;
        int[] leftdp=help(root.left);
        int[] rightdp=help(root.right);
        dp[0]=Math.max(leftdp[0]+rightdp[1],leftdp[1]+rightdp[0]);
        dp[1]=root.val+leftdp[0]+rightdp[0];
        return dp;
    }
}

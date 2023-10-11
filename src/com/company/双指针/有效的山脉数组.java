package com.company.双指针;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-10 14:36
 */
public class 有效的山脉数组 {
    public static void main(String[] args) {
        System.out.println(validMountainArray1(new int[]{0,3,2,1}));
    }
    public static boolean validMountainArray(int[] arr) {
        if(arr.length<3)return false;
        int maxindex=0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i]>arr[maxindex]) maxindex=i;
        if (maxindex==arr.length-1||maxindex==0)return false;
        int left=0;int right=arr.length-1;
        while (left++<maxindex){
            if (arr[left]<=arr[left-1]) return false;
        }
        while (right-->maxindex){
            if (arr[right]<=arr[right+1]) return false;
        }
        return true;
    }
    public static boolean validMountainArray1(int[] arr) {
        if(arr.length<3)return false;
        int left=0;int right=arr.length-1;
        while (left+1 < arr.length&&arr[left+1]>arr[left])left++;
        while (right-1>=0&&arr[right-1]>arr[right]) if (arr[right-1]>arr[right]) right--;
        if(left!=0&&right!=arr.length-1&&left==right) return true;
        return false;
    }
    public int maxProfit(int k, int[] prices) {
        int[][] dp=new int[prices.length][(2*k)+1];
        for(int i=1;i<prices.length;i+=2){
            dp[0][i]=-prices[0];
        }
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=(2*k)+1;j++){
                if(j%2==1) dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]-prices[i]);
                else dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+prices[i]);
            }
        }
        return  Arrays.stream(dp[prices.length-1]).max().getAsInt();
    }
}

package com.company.数组;

import java.util.Arrays;
import java.util.Map;

/**
 * @author xiu
 * @create 2023-11-03 18:17
 */
public class 马戏团人塔 {
//    height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
    public static void main(String[] args) {
        System.out.println(bestSeqAtIndex(new int[]{2868,5485,1356,1306,6017,8941,7535,4941,6331,6181}, new int[]{5042,3995,7985,1651,5991,7036,9391,428,7561,8594}));
    }
//    这个是错的,不能用dp要用二分
    static int bestSeqAtIndex(int[] height, int[] weight) {
        int length = height.length;
        int[][] arr=new int[length][2];
        for (int i = 0; i < length; i++) {
            arr[i][0]=height[i];
            arr[i][1]=weight[i];
        }
        Arrays.sort(arr,(a,b)->{
         if (a[1]==b[1]){
             return a[0]-b[0];
         }else{
             return b[1]-a[1];
         }
        });
        System.out.println(Arrays.deepToString(arr));
        int ans=-1;
        int[] dp=new int[arr.length];
        dp[0]=1;
        for (int i = 1; i < arr.length; i++) {
            int left=i;int right=arr.length-1;
            while (left<=right){
                int mid=(left+right)/2;
                int target=arr[i][0];
                if (arr[mid][0]<target){

                }
            }
            dp[i]+=1;
            ans= Math.max(ans,dp[i]);
        }
        return ans;
    }
}

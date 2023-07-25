package company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 22:28
 */
public class 最长重复子数组 {
    public static void main(String[] args) {
        new 最长重复子数组().findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7});
    }
    public int findLength(int[] nums1, int[] nums2) {
        int res=0;
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <=nums2.length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}

package company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-21 22:28
 */
public class 最长重复子数组 {
    public static void main(String[] args) {
        System.out.println(new 最长重复子数组().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(new 最长重复子数组().findLength1(new int[]{1, 2, 3, 4, 5}, new int[]{99}));
        System.out.println(new 最长重复子数组().findLength2(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
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
            System.out.println(Arrays.deepToString(dp));

        }
        return res;
    }


    public int findLength1(int[] nums1, int[] nums2){
        int res=0;
//        dp i j表示 nums1长为i, nums2 长为j的子数组的公共子数组长度
        int[][] dp=new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) if (nums2[0]==nums1[i]){ dp[i][0]=1;res=1;}
        for (int i = 0; i < nums2.length; i++) if (nums1[0]==nums2[i]){ dp[0][i]=1;res=1;}
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res=Math.max(res,dp[i][j]);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return res;
    }
    public int findLength2(int[] nums1, int[] nums2){
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int max=Integer.MIN_VALUE;
        for (int i = 1; i <=nums1.length; i++) {
            for (int j = 1; j <=nums2.length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
                max=Integer.max(max,dp[i][j]);
            }
        }
        return max;
    }
}

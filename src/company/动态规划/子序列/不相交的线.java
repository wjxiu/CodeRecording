package company.动态规划.子序列;

/**
 * @author xiu
 * @create 2023-07-22 22:05
 */
public class 不相交的线 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+2][nums2.length+2];
        int res=0;
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;i++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
                res=Math.max(dp[i][j],res);
            }
        }
        return res;
    }
}

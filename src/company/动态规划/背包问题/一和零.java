package company.动态规划.背包问题;

/**
 * @author xiu
 * @create 2023-07-20 14:27
 */
public class 一和零 {
//    m0 n1
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j] 含义 i个0 j个1包含的最大子集元素个数
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int count0=0;
            int count1=0;
            for (char c : str.toCharArray()) {
                if (c=='0') count0++;
                else count1++;
            }
//            dp[i][j]=max{dp[i][j],dp[i-count0][j-count1]+1}
            for (int j = m; j>=count0; j--) {
                for (int k = n; k >=count1 ; k--) {
                    dp[j][k]=Math.max(dp[j][k],dp[j-count0][j-count1]+1);
                }
            }
        }
        return dp[m][n];
    }
}

package company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-23 10:47
 */
public class 不同的子序列 {
    public static void main(String[] args) {
        System.out.println(new 不同的子序列().numDistinct("rabbbit", "rabit"));
        int a=12_00_00;
        System.out.println(a);
    }
    public  int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for (int j = 0; j < t.length(); j++) {
            dp[0][j]=0;
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][0]=1;
        }
        dp[0][0]=1;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[s.length()][t.length()];
    }
}

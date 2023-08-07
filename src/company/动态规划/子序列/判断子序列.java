package company.动态规划.子序列;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-22 22:46
 */
public class 判断子序列 {
    public static void main(String[] args) {
        System.out.println(new 判断子序列().isSubsequence1("3wewe", "ahbgdc"));
    }

    //    dp
//    dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
    public boolean isSubsequence(String s, String t) {
        int length = s.length();
        int tlength=t.length();
        int[][] dp=new int[length +1][tlength+1];
        for (int i = 1; i <=length; i++) {
            for (int j = 1; j <=tlength; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[length][tlength]== length;
    }
//ace"是"abcde
    public boolean isSubsequence1(String s, String t){
        int[][] dp=new int[s.length()+1][t.length()+1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[s.length()][t.length()]==s.length();
    }
    //    双指针
    public boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }
}

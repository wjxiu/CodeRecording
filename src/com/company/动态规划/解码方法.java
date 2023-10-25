package com.company.动态规划;

/**
 * @author xiu
 * @create 2023-11-07 16:41
 */
public class 解码方法 {
    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }
    static int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        s=" "+s;
        for (int i = 1; i < s.length(); i++) {
            int l=s.charAt(i-1)-'0';
            int a =s.charAt(i)-'0';
            int b=l*10+ a;
            if ((a >=1&& a <=9)&&(b>=10&&b<=26)){
                dp[i]=dp[i-1]+dp[i-2];
            }
            else if (a >=1&& a <=9){
                dp[i]=dp[i-1];
            }
            else if (b>=10&&b<=26){
                dp[i]=dp[i-2];
            }
        }
        return dp[dp.length-1];
    }
}

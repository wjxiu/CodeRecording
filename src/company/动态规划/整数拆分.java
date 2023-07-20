package company.动态规划;

/**
 * dp i	=j*(i-j)	j*dp[i-j]
 * @author xiu
 * @create 2023-07-19 21:12
 */
public class 整数拆分 {
    public static void main(String[] args) {
        System.out.println(new 整数拆分().integerBreak(10));
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <=n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}

package company.动态规划;

/**
 * @author xiu
 * @create 2023-07-19 19:10
 */
public class 爬楼梯 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n; i++) {
           dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

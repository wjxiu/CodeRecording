package company.动态规划;

/**
 * dp[m,n]	(0,0)-(m,n)	的距离
 * 初始化	左边全1	上边全1	机器人自己也是1
 * 遍历顺序	左到右，上到下
 * 公式	dp[i][j]	eq	dp[i-1][j]	adddp[i][j-1]
 * @author xiu
 * @create 2023-07-19 20:08
 */
public class 不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}

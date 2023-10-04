package com.company.动态规划;

/**
 * dp[m,n]	(0,0)-(m,n)	的距离
 * 初始化	左边全1	上边全1	机器人自己也是1
 * 遍历顺序	左到右，上到下
 * 公式	dp[i][j]	eq	dp[i-1][j]	adddp[i][j-1],如果是石头 =0
 *
 * @author xiu
 * @create 2023-07-19 20:18
 */
public class 不同路径2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int a=0;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

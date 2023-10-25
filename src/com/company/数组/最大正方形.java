package com.company.数组;

/**
 * 这个不会
 * @author xiu
 * @create 2023-11-12 18:47
 */
public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i + 1][j + 1] == '0') continue;
                dp[i+1][j+1] = Math.min(dp[i][j], Math.max(dp[i + 1][j], dp[i][j+1]))+1;
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}

package com.company.回溯;

import com.company.公共类.工具类.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xiu
 * @create 2023-10-26 20:59
 */
public class 生成括号 {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return res;
    }

    /**
     * @param open  表示path中左括号的个数
     * @param close 表示path中右括号的个数
     * @param n     括号对数
     */
    void dfs(int open, int close, int n) {
//        右括号过多
        if (close > open) return;
        //左括号多过总数的一半(也就是n)
        if (open > n) return;
        if (path.length() == 2 * n) {
            res.add(path.toString());
        }
        path.append("(");
        dfs(open + 1, close, n);
        path.deleteCharAt(path.length() - 1);
        path.append(")");
        dfs(open, close + 1, n);
        path.deleteCharAt(path.length() - 1);
    }


    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    static void fill(int[][] image, int sr, int sc, int newColor, int old) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if (image[sr][sc] == newColor) return;
        if (image[sr][sc] != old) return;
        if ((image[sr][sc] == old)) image[sr][sc] = newColor;
        fill(image, sr + 1, sc, newColor, old);
        fill(image, sr - 1, sc, newColor, old);
        fill(image, sr, sc + 1, newColor, old);
        fill(image, sr, sc - 1, newColor, old);
    }



    static int waysToChange(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int[] coins = new int[]{1, 5, 10, 25};
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= coins[i]) dp[j] += dp[j - coins[i]] % 1000000007;
            }
        }
        return (int) dp[n] % 1000000007;
    }
}

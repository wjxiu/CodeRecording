package com.company.图;

import com.company.公共类.工具类.LeetCodeUtils;

/**
 * @author xiu
 * @create 2023-10-31 20:11
 */
public class 封闭岛屿数量 {
    public static void main(String[] args) {
        System.out.println(0.1+0.2);
//        System.out.println(closedIsland(LeetCodeUtils.parseToIntArray(
//                "[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0],[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1],[1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0],[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]\n"
//        )));
    }

    static int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 0&&dfs(grid, i, j)) count++;
        }
        return count;
    }

    static boolean dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length ) return false;
        if (grid[x][y] != 0) return true;
        grid[x][y] = 1;
           boolean res1=    dfs(grid, x + 1, y) ;
           boolean res2=    dfs(grid, x-1, y ) ;
           boolean res3=    dfs(grid, x , y+1) ;
           boolean res4=    dfs(grid, x, y - 1);
           return res1&&res2&&res3&&res4;
    }

}

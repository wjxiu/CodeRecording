package com.company.动态规划;

import com.company.公共类.工具.LeetCodeUtils;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * @author xiu
 * @create 2023-08-08 14:52
 */
public class 粉刷房子 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        List dynamicArray = (List)new dynamicArray().getinstance(integers);
        System.out.println(dynamicArray.add(1));
//        System.out.println(dynamicArray);
//        System.out.println(new 粉刷房子().minCost(LeetCodeUtils.parseToIntArray("[[3,5,3],[6,17,6],[7,13,18],[9,10,18]]")));
    }
    public int minCost(int[][] costs){
//        当第 i 个房子粉刷颜色 j 时，粉刷 [0..i] 这些房子所需的最少花费为 dp[i][j]。
        int[][] dp=new int[costs.length][3];
        for (int i = 0; i < 3; i++) dp[0][i]=costs[0][i];
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j <3; j++) {
                dp[i][j]=Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3])+costs[i][j];
            }
        }
        return Arrays.stream(dp[costs.length-1]).min().getAsInt();
    }
}


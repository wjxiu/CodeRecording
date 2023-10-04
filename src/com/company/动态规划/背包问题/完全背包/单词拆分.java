package com.company.动态规划.背包问题.完全背包;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-21 10:34
 */
public class 单词拆分 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("leet", "code");
        System.out.println(new 单词拆分().wordBreak("leetcode", strings));
        System.out.println(new 单词拆分().wordBreak1("leetcode", strings));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }


    public boolean wordBreak1(String s, List<String> wordDict){
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 0; i <=s.length(); i++) {
            for (int j = 0; j <i; j++) {
                String substring = s.substring(j, i);
                if (dp[j]&&wordDict.contains(substring)){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }
}

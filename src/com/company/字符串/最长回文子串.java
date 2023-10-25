package com.company.字符串;

import java.math.BigInteger;
import java.util.*;

/**
 * @author xiu
 * @create 2023-11-05 19:18
 */
public class 最长回文子串 {
    static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = Palindrome(s, i,i);
            String temp1 = Palindrome(s, i,i+1);
            res=temp.length() > res.length()?temp:res;
            res=temp1.length() > res.length()?temp1:res;
        }
        return res;
    }
    static String Palindrome(String s, int mid,int mid1) {
        int left = mid;
        int right = mid1;
        while (left >=0 && right < s.length()&&s.charAt(left) == s.charAt(right) ) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
 static   StringBuilder sb=new StringBuilder();
 static   List<String> list=new ArrayList<>();
    static List<String> generateParenthesis(int n) {
        back(0,0,n,0);
        return list;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10000; i++) {
            System.out.println(i+"---"+catlan(i));
        }
    }
  static BigInteger catlan(int n){
        BigInteger[] dp=new BigInteger[n+1];dp[0]=BigInteger.ONE;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i]==null)dp[i]=BigInteger.ZERO;
               dp[i]= dp[i].add(dp[i-j-1].multiply(dp[j]));
            }
        }
        return dp[n];
    }
  static   void back(int l,int r,int n,int index){
        if (l<r)return;
        if (sb.length()==2*n&&l==r){
            list.add(sb.toString());
            return;
        }
        for (int i = index; i <2*n; i++) {
            sb.append("(");
            back(l+1,r,n,i+1);
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
            back(l,r+1,n,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

package com.company.字符串;

/**
 * @author xiu
 * @create 2023-07-27 13:08
 */
public class 重复的子字符串 {
    public static void main(String[] args) {
        System.out.println(new 重复的子字符串().repeatedSubstringPattern("ababab"));
    }
//     暴力
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length()/2; i++) {
            String sub = s.substring(0, i);
            StringBuilder sb = new StringBuilder(sub);
            while (sb.length()<=s.length()) {
                sb.append(sub);
                if (sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}

package com.company.字符串;

/**
 * @author xiu
 * @create 2023-07-12 10:22
 */
public class 反转字符串II {
    public static void main(String[] args) {
        System.out.println(new 反转字符串II().reverseStr1("abcdefg", 3));
    }
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2*k) {
            int end=Math.min(s.length()-1,i+k-1);
            for (int j = i; j < end; j++) {
                char temp='-';
                temp=chars[j];
                chars[j]=chars[end];
                chars[end]=temp;
                end--;
            }
        }
        return new String(chars);
    }
    public String reverseStr1(String s, int k){
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i+=2*k) {
            int end=Math.min(s.length()-1,i+k);
            int start=i;
            while (start<end){
                char temp;
                temp=chars[start];
                chars[start]=chars[end];
                chars[end]=temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}

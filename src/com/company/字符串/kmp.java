package com.company.字符串;



import com.company.公共类.ListNode;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-12 13:41
 */
public class kmp {
    public static void main(String[] args) {
        String a = "mississippi";
        String b = "issip";
        System.out.println(new kmp().strStr(a, b));
        System.out.println(new kmp().strStr1(a, b));
    }

    public int strStr(String haystack, String needle) {
        int[] next = getnext(needle);
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int j = 0;
        for (int i = 0; i < h.length; i++) {
            while (j > 0 && h[i] != n[j]) {
                j = next[j - 1];
            }
            if (h[i] == n[j]) {
                j++;
            }
            if (j == n.length) {
                return i - (n.length - 1);
            }
        }
        return -1;
    }
    //    生成kmp的next数组
    int[] getnext(String s) {
        char[] chars = s.toCharArray();
        int[] next = new int[s.length()];
//        i:前缀的末尾
//        j:后缀的开头
        int i = 0;
        for (int j = 1; j < s.length(); j++) {
            while (i > 0 && chars[j] != chars[i]) {
                i = next[i - 1];
            }
            if (chars[j] == chars[i]) {
                i++;
                next[j] = i;
            }
        }
        return next;
    }

    public int strStr1(String haystack, String needle) {
        int[] next = getnext1(needle);
        int j = 0;//need的指针
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            if (j == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }
    int[] getnext1(String s) {
        char[] chars = s.toCharArray();
        int[] next = new int[s.length()];
        int i = 0;
        for (int j = 1; j < s.length(); j++) {
            while (i >= 1 && chars[i] != chars[j]) {
                i = next[i - 1];
            }
            if (chars[i] == chars[j]) {
                i++;
                next[j] = i;
            }
        }
        return next;
    }

}

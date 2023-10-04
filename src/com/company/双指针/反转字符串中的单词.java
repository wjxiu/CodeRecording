package com.company.双指针;

/**
 * @author xiu
 * @create 2023-07-13 9:46
 */
public class 反转字符串中的单词 {
    public static void main(String[] args) {

        System.out.println(new 反转字符串中的单词().reverseWords("the sky is blue"));

    }

    public String reverseWords(String s) {
        StringBuilder stringBuilder = removeSpace(s);
        StringBuilder reverse = reverse(stringBuilder, 0, stringBuilder.length() - 1);
        StringBuilder stringBuilder1 = reverseEach(reverse);
        return stringBuilder1.toString();
    }

    private StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        while (start <= end) {
            if (s.charAt(start) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(start));
            }
            start++;
        }
        return sb;
    }

    StringBuilder reverse(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
        return s;
    }

    StringBuilder reverseEach(StringBuilder s) {
        int start = 0;
        int end = 0;
        while (start < s.length()) {
            while (end < s.length() && s.charAt(end) != ' ') end++;
            reverse(s, start, end - 1);
            start = end + 1;
            end++;
        }
        return s;
    }
}

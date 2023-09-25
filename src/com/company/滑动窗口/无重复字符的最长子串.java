package com.company.滑动窗口;

import java.util.HashSet;

/**
 * @author xiu
 * @create 2023-09-25 19:31
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(new 无重复字符的最长子串().lengthOfLongestSubstring("abca"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        HashSet<Character> set = new HashSet<>();
        int i=0,j=0,res=0;
        char[] charArray = s.toCharArray();
        while (i<charArray.length){
            if (i!=0) set.remove(charArray[j-1]);
            while(i< charArray.length&&!set.contains(charArray[i])) {
                set.add(charArray[i]);
                i++;
            }
//            这里不用i-j+1的原因是while循环是找到重复的才跳出循环,i指向的是重复的字符,i-1才是不重复子串的最后一位的索引
            res=Math.max(res, i-j);
            j++;
        }
        return res;
    }
    public int lengthOfLongestSubstring1(String s) {
        int[] last=new int[128];
        for (int i = 0; i < 128; i++) last[i]=-1;
        int res=0,start=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            记录着重复字符的下一位，也就是整个结果子串的开始位置
            start=Math.max(start,last[c]+1);
            res=Math.max(res,i-start+1);
            last[c]=i;
        }
        return res;
    }
}

package com.company.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author xiu
 * @create 2023-11-01 13:48
 */
public class T9键盘 {
    public static void main(String[] args) {
        System.out.println(new T9键盘().getValidT9Words("2",
                new String[]{"a", "b","c","d"}));
    }
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        int[] map=new int[]{2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        for (String s : words) {
            int i=0;
            while (i<s.length()) {
                char c1 = s.charAt(i);
                if (map[c1 - 'a'] !=Integer.parseInt(num.charAt(i)+"")) break;
                i++;
            }
            if (i==s.length())res.add(s);
        }
        return res;
    }
}

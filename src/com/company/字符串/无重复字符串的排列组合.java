package com.company.字符串;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-08-29 20:06
 */
public class 无重复字符串的排列组合 {
    public static void main(String[] args) {
        new 无重复字符串的排列组合().permutation("qqac");
    }

    ArrayList<String> res = new ArrayList<String>();
    boolean[] used;

    public String[] permutation(String S) {
        char[] charArray = S.toCharArray();
        Arrays.sort(charArray);
        used=new boolean[S.length()];
        backtrack(charArray, new StringBuilder());
        return res.toArray(new String[]{});
    }

    void backtrack(char[] charArray, StringBuilder temp) {
        if (temp.length() == charArray.length) {
            res.add(temp.toString());
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
           if (used[i]||(i>0&&charArray[i]==charArray[i-1]&&used[i-1])) continue;
           used[i]=true;
            temp.append(charArray[i]);
            backtrack(charArray, temp);
            used[i]=false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}

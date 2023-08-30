package com.company.字符串;

import java.util.*;

/**
 * 没做出来
 * @author xiu
 * @create 2023-08-30 15:07
 */
public class 珠玑妙算 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 珠玑妙算().masterMind("BGBG", "RGBR")));
    }

    public int[] masterMind(String solution, String guess) {
        int[] res = new int[2];
        char[] charArray = guess.toCharArray();
        char[] solu = solution.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : solu) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < charArray.length; i++) {
            char g = charArray[i];
            char s = solu[i];
            if (s == g) {
                res[0]++;
                map.put(g, 0);
            }

        }
        for (int i = 0; i < charArray.length; i++) {
            char g = charArray[i];
            char s = solu[i];
            if (map.containsKey(g) && map.get(g) > 0) {
                res[1]++;
                map.put(g, map.get(g) - 1);
            }
        }
        return res;
    }
}


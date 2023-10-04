package com.company.公共类.工具类;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-08-02 15:15
 */
public class LeetCodeUtils {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(LeetCodeUtils.parseToIntArray("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]")));
    }
    public static int[] geneIntArr(String s) {
        String regex = "\\D+"; // 匹配一个或多个数字
        String[] split = s.split(regex);
        return Arrays.stream(split).filter(i-> i.length()>0).mapToInt(Integer::parseInt).toArray();
    }
    public static int[][] parseToIntArray(String input) {
        return new Gson().fromJson(input, int[][].class);
    }
}

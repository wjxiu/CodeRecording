package com.company.公共类.工具类;
import com.company.公共类.ListNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

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
        return Arrays.stream(split).filter(i-> !i.isEmpty()).mapToInt(Integer::parseInt).toArray();
    }
    public static int[][] parseToIntArray(String input) {
        return new Gson().fromJson(input, int[][].class);
    }
    public static String[][] parseToStrArray(String input) {return new Gson().fromJson(input,String[][].class);}
    public static char[][] parseTocharArray(String input) {return new Gson().fromJson(input,char[][].class);}
    public static <T> T[][] parseTo2DArray(String input) {return new Gson().fromJson(input, new TypeToken<T[][]>() {}.getType());}
    public static <T> T[][] parseTo2DArrayfromFile(String file) {String input= read(file);return new Gson().fromJson(input, new TypeToken<T[][]>() {}.getType());}
    public static int[][] parseToIntArrayfromFile(String file) {String input= read(file);return new Gson().fromJson(input, int[][].class);}
    public static String[][] parseToStrArrayfromFile(String file) {String input= read(file);return new Gson().fromJson(input,String[][].class);}
    public static char[][] parseTocharArrayfromFile(String file) {String input= read(file);return new Gson().fromJson(input,char[][].class);}

    private static String read(String file){
        StringBuilder sb=new StringBuilder();
        try {
            List<String> list = Files.readAllLines(Path.of(file));
            for (String s : list) {
                sb.append(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static ListNode parseToNodesfromFile(String files)  {
        ListNode head = new ListNode();
        ListNode temp = head;

        try {
            List<String> list = Files.readAllLines(Path.of(files));
            Gson gson = new Gson();
            for(String node:list){
                int[] ints = gson.fromJson(node, int[].class);
                for (int i: ints) {
                    temp.next=new ListNode(i);
                    temp=temp.next;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return head.next;
    }
}

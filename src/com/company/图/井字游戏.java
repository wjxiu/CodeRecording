package com.company.图;

import com.company.公共类.工具类.LeetCodeUtils;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-28 19:46
 */
public class 井字游戏 {

//    for(int i)
//        for(int j)
//    int length= borad.length
//    在遍历过程中获取行和列 正副对角线都可以一次遍历获取
//    获取行:borad[i][j]
//    获取列:borad[j][i]
//    获取正对角线:borad[i][i]
//    获取副对角线:borad[i][length-i-1] (副对角线的i+j相加等于length-1)

    static String tictactoe(String[] board) {
        int numdigleft = 0;
        int numdigright = 0;
        int size = board.length;
        int rowsize = board[0].length();
        int isfull = 1;
        for (int i = 0; i < size; i++) {
            int colnum = 0;
            int rownum = 0;
            String row = board[i];
            numdigleft += (int) row.charAt(i);
            numdigright += (int) row.charAt(rowsize - i - 1);
            for (int j = 0; j < rowsize; j++) {
                if (row.charAt(j) == ' ') isfull = 0;
                rownum += (int) row.charAt(j);
                colnum += (int) board[j].charAt(i);
            }
            if (rownum == size * 'O' || colnum == size * 'O') return "O";
            if (rownum == size * 'X' || colnum == size * 'X') return "X";
        }
        if (numdigleft == size * 'X' || numdigright == size * 'X') return "X";
        if (numdigleft == size * 'O' || numdigright == size * 'O') return "O";
        return isfull == 1 ? "Draw" : "Pending";
    }
    static int smallestDifference(int[] a, int[] b) {
        int pa=0;int pb=0;
        Arrays.sort(a);
        Arrays.sort(b);
        long sub=Long.MAX_VALUE;
        while (pa<a.length&&pb<b.length){
            sub=Math.min(sub,Math.abs((long)a[pa]-b[pb]));
            if (a[pa]>b[pb]){
                pb++;
            }else{
                pa++;
            }
        }
        return (int)sub;
    }
    public static void main(String[] args) {
        System.out.println(tictactoe(new String[]{" O    X", " O     ", "     O ", "XXXXXXX", "  O    ", " O   O ", "O  X OO"}));

    }

}

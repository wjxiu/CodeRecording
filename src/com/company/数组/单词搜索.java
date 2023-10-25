package com.company.数组;

import java.util.List;

/**
 * @author xiu
 * @create 2023-10-20 11:31
 */
public class 单词搜索 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
        };
        String word = "aaaaaaaaaaaaa";
        long l = System.currentTimeMillis();
        System.out.println(new 单词搜索().exist(board, word));
        System.out.println(System.currentTimeMillis() - l);
    }

    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        boolean res;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                res = check(board, word, i, j, 0);
                if (res) return true;
            }
        }
        return false;
    }

    boolean check(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || used[i][j] || k > word.length())
            return false;
        if (word.charAt(k) != board[i][j]) return false;
        if (k == word.length() - 1) return true;
        used[i][j] = true;
        if (check(board, word, i + 1, j, k + 1)) return true;
        if (check(board, word, i - 1, j, k + 1)) return true;
        if (check(board, word, i, j - 1, k + 1)) return true;
        if (check(board, word, i, j + 1, k + 1)) return true;
        used[i][j] = false;
        return false;
    }
}

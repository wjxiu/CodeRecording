package com.company.数组;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-20 12:00
 */
public class 单词搜索II {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                {'a'}
        };
        String[] words=new String[]{"aaaaaaaaaa"};
        long l = System.currentTimeMillis();
        System.out.println(new 单词搜索II().findWords(board, words));
        System.out.println(System.currentTimeMillis()-l);
    }
    HashSet<String> set=new HashSet<>();
    boolean[][] used;
    ArrayList<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        used=new boolean[board.length][board[0].length];
        set.addAll(Arrays.asList(words));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                bfs(board,i,j,new StringBuilder());
            }
        }
        return res;
    }
    void bfs(char[][] board,int i,int j,StringBuilder sb){
        if (sb.length()>10)return;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || used[i][j] ) return;
        sb.append(board[i][j]);
        used[i][j]=true;
        String string = sb.toString();
        if (set.contains(string)){
            res.add(string);
            set.remove(string);
        }
        bfs(board, i, j+1, sb);
        bfs(board, i, j-1, sb);
        bfs(board, i+1, j, sb);
        bfs(board, i-1, j, sb);
        used[i][j]=false;
        sb.deleteCharAt(sb.length()-1);
    }

}


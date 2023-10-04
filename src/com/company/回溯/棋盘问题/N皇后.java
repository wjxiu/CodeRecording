package com.company.回溯.棋盘问题;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiu
 * @create 2023-08-01 11:23
 */
public class N皇后 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        back(n,0, chessboard);
        return res;
    }
    void back(int n,int row,char[][] chessboard){
        if (row==n){
            ArrayList<String> list = new ArrayList<>();
            for (char[] chars : chessboard) {
                String s = new String(chars);
                list.add(s);
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < chessboard[row].length; i++) {
            if (isValid(chessboard,row,i)){
                chessboard[row][i]='Q';
                back(n,row+1, chessboard);
                chessboard[row][i]='.';
            }
        }
    }
    boolean isValid(char[][] chessborad,int row,int column){
        for (int i = 0; i < row; i++) {
            if (chessborad[i][column]=='Q') {
                return false;
            }
        }
        for (int i = row-1 ,j=column-1; i>=0&&j>=0; i--,j--) {
            if (chessborad[i][j]=='Q') return false;
        }
        for (int i = row-1 ,j=column+1; i>=0&&j<= chessborad.length-1; i--,j++) {
            if (chessborad[i][j]=='Q') return false;
        }
        return true;
    }
}

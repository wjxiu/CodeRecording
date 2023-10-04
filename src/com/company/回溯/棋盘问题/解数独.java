package com.company.回溯.棋盘问题;

/**
 * @author xiu
 * @create 2023-08-01 11:55
 */
public class 解数独 {
    public void solveSudoku(char[][] board) {
        back(board);
    }
    boolean back(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (char k = '1'; k < '9'; k++) {
                    if (isValid(i,j,k,board)){
                        board[i][j]=k;
//                        不太懂这一行
                        if (back(board)) return true;
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, int k, char[][] board) {
//        判断同行
        for (int i = 0; i <= board.length; i++) {
            if (board[row][i]==k) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col]==k) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startCol; j < startCol+3; j++) {
                if (board[i][j]==k) return false;
            }
        }
        return true;
    }
}

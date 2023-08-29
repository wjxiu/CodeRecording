package com.company.字符串;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 十滴水
 * @author xiu
 * @create 2023-08-29 19:15
 */
public class 零矩阵 {
    public static void main(String[] args) {
        int[][] arr=   new int[][]{
                {1,2,0},
                {0,5,6},
                {7,8,9},
        };
        new 零矩阵().setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }
    public void setZeroes(int[][] matrix) {
        boolean[] row=new boolean[matrix.length];
        boolean[] col=new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i]||col[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
}

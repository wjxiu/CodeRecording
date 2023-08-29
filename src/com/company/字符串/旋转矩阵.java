package com.company.字符串;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-08-29 18:50
 */
public class 旋转矩阵 {
    public static void main(String[] args) {
     int[][] arr=   new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
     new 旋转矩阵().rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }
    //    右到左反转，然后上下颠倒
    public void rotate(int[][] matrix) {
        int up = 0;
        int down = matrix.length - 1;
//        上下翻转
        while (up < down) {
            int[] temp = matrix[up];
            matrix[up] = matrix[down];
            matrix[down] = temp;
            up++;
            down--;
        }

//        主对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length ; j++) {
                System.out.println(matrix[i][j]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

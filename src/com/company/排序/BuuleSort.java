package com.company.排序;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-04 20:51
 */
public class BuuleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 2, 6, 3, 4, 2, 8, 7, 15, 4, 8, 7, 6, 9, 7, 9, 2, 1, 12, 14};
        System.out.println(Arrays.toString(BuuleSort(arr)));
    }
    public static int[] BuuleSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i]> arr[j]){
                    int temp= arr[i];
                    arr[i]= arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}

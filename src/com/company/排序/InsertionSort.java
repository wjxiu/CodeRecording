package com.company.排序;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-05 15:35
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 2, 6, 3, 4, 2, 8, 14};
        System.out.println(Arrays.toString(InsertionSort.insertionSort(arr)));
    }
    public static int[] insertionSort(int[] sourcearr) {
        int[] arr = Arrays.copyOf(sourcearr, sourcearr.length);
//        arr[i]是待排序的数组，没有加入到排好序的数组里
        for (int i = 1; i < arr.length; i++) {
//            j用于遍历已经排好序的数组
            int j=i;
            int temp=arr[i];
            while (j>=0&&temp<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            if (j!=i) arr[j]=temp;

        }
        return arr;
    }
}

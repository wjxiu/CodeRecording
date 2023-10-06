package com.company.排序;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-04 20:55
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 2, 6, 3, 4, 2, 8, 7, 15, 4, 8, 7, 6, 9, 7, 9, 2, 1, 12, 14};
        System.out.println(Arrays.toString(SelectionSort(arr)));
    }

    public static int[] SelectionSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int last = arr.length - 1;
        while (last >= 0) {
            int maxindex = last;
            for (int i = 0; i < last; i++) if (arr[i] > arr[maxindex]) maxindex = i;
            int temp = arr[maxindex];
            arr[maxindex] = arr[last];
            arr[last] = temp;
            last--;
        }
        return arr;
    }
}

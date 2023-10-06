package com.company.排序;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author xiu
 * @create 2023-10-05 17:13
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 2, 6, 3, 4, 2, 8, 14};
        System.out.println(Arrays.toString(QuickSort.QuickSort(arr)));
    }
    public static int[] QuickSort(int[] source) {
        int[] arr = Arrays.copyOf(source, source.length);
        QuickSort(arr,0,arr.length-1);
        return arr;
    }

    private static void QuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int postion = QuickSortHelp(arr, left, right);
            QuickSort(arr, left, postion - 1);
            QuickSort(arr, postion + 1, right);
        }
    }
//    返回中轴点，QuickSort递归切割
    private static int QuickSortHelp(int[] source, int left, int right) {
        int slow = left;
        int fast = left;
//        这里将pivrot设置为下标而不是具体的数字
        int pirvot = right;
//    类似leetcode 27题目,将小于pirvot的数字放在pirvot的左边，也就是交换slow和fast,
        while (fast < right) {
            if (source[fast] < source[pirvot]) {
                int temp=source[slow];
                source[slow]=source[fast];
                source[fast] = temp;
                slow++;
            }
            fast++;
        }
        int temp=source[slow];
        source[slow]=source[pirvot];
        source[pirvot] = temp;
        return slow;
    }
}
package com.company.排序;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-05 15:57
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 2, 6, 3, 4, 2, 8, 7, 15, 4, 8, 7, 6, 9, 7, 9, 2, 1, 12, 14};
        System.out.println(Arrays.toString(MergeSort(arr)));
    }
    public static int[] MergeSort(int[] sourcearr){
        int[] arr = Arrays.copyOf(sourcearr, sourcearr.length);
//        左闭右闭
         help(arr,0, arr.length-1);
         return arr;
    }
    private static void help(int[] source,int left,int right){
        if (left<right) {
            int mid = (left + right) / 2;
            help(source, left, mid);
            help(source, mid + 1, right);
            merge(source,left,mid,right);
        }
    }
    private static void merge(int[] arr,int left,int mid,int right){
        //因为api是左闭右开的，我的定义是左闭右闭，需要右边加1
        int[] leftarr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightarr = Arrays.copyOfRange(arr, mid+1, right+1);
        int[] merge = new int[leftarr.length+rightarr.length];
        int l = 0, r = 0,t = 0;
        while (l < leftarr.length && r < rightarr.length) {
            if (leftarr[l] > rightarr[r]) merge[t++] = rightarr[r++];
            else merge[t++] = leftarr[l++];
        }
        while (l < leftarr.length) merge[t++] = leftarr[l++];
        while (r < rightarr.length) merge[t++] = rightarr[r++];
        for (int i = left; i <=right; i++) arr[i]= merge[i-left];
    }
}
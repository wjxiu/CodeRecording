package com.company.排序;

import com.company.测试.Person;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiu
 * @create 2023-08-09 17:12
 */
public class 排序 {
    public static void main(String[] args) {
        Person.builder builder = Person.builder();
//        System.out.println(Arrays.toString(排序.bubbleSort(arr)));
//      degree = "bbbb"  System.out.println(Arrays.toString(排序.selectionSort(arr)));
//        System.out.println(Arrays.toString(排序.insertionSort(arr)));
//        System.out.println(Arrays.toString(排序.mergeSort(arr,0, arr.length-1, new int[arr.length])));
//        System.out.println(Arrays.toString(排序.quickSort(arr,0, arr.length-1)));
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int last = arr.length - 1;
        while (last >= 0) {
            int maxindex = last;
            for (int i = 0; i < last; i++) if (arr[i] > arr[maxindex]) maxindex = i;
            int temp = arr[last];
            arr[last] = arr[maxindex];
            arr[maxindex] = temp;
            last--;
        }
        return arr;
    }


    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pre = i - 1;
            int curr = arr[i];
            while (pre >= 0 && curr < arr[pre]) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = curr;
        }
        return arr;
    }
//  todo  希尔

//  归并排序
    public static int[] mergeSort(int[] arr, int l, int r,int []temp) {
        if (l<r){
            int mid = (l+r)/2;
            mergeSort(arr,l,mid,temp);
            mergeSort(arr,mid+1,r,temp);
            merge(arr,l,mid,r,temp);
        }
        return arr;
    }
// 归并排序辅助函数
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            }else{
                temp[t++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[t++]=arr[i++];
        }
        while (j<=right){
            temp[t++]=arr[j++];
        }
        t=0;
        while(left <= right) arr[left++] = temp[t++];
    }




    public static int[] quickSort(int[]arr,int low,int high){
        if (low<high){
            int postion = quickSortHelper(arr, low, high);
            quickSort(arr,low,postion-1);
            quickSort(arr,postion+1,high);
        }
        return arr;
    }
    private static int quickSortHelper(int[]arr,int low,int high){
        int pivot=arr[high];
        int slow =low;
//        这个和找到leetcode 27题目 移除元素有点像，都是和某个元素比较的
        int fast=low;
        while (fast<high){
            if (arr[fast]<=pivot){
                int temp=arr[fast];
                arr[fast]=arr[slow];
                arr[slow]=temp;
                slow++;
            }
            fast++;
        }
        int temp = arr[slow];
        arr[slow] = arr[high];
        arr[high] = temp;
        return slow;
    }
}
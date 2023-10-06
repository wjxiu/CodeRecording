package com.company.排序;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-08-09 17:12
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 2, 6, 3, 4, 2, 8, 7, 15, 4, 8, 7, 6, 9, 7, 9, 2, 1, 12, 14};
//        System.out.println(Arrays.toString(Sort.bubbleSort(arr)));
        System.out.println(Arrays.toString(Sort.selectionSort(arr)));
//        System.out.println(Arrays.toString(Sort.insertionSort(arr)));
//        System.out.println(Arrays.toString(Sort.mergeSort(arr,0, arr.length-1, new int[arr.length])));
//        System.out.println(Arrays.toString(Sort.quickSort(arr,0, arr.length-1)));
//        System.out.println(Arrays.toString(Sort.CountingSort(arr)));
    }

    public static int[] bubbleSort(int[] arr) {
        int[] arrcopy = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arrcopy.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arrcopy[j] > arrcopy[i]) {
                    int temp = arr[i];
                    arrcopy[i] = arrcopy[j];
                    arrcopy[j] = temp;
                }
            }
        }
        return arrcopy;
    }

    public static int[] selectionSort(int[] arr) {
        int[] arrcopy = Arrays.copyOf(arr, arr.length);
        int last = arrcopy.length - 1;
        while (last >= 0) {
            int maxindex = last;
            for (int i = 0; i < last; i++) if (arrcopy[i] > arrcopy[maxindex]) maxindex = i;
            int temp = arrcopy[last];
            arrcopy[last] = arrcopy[maxindex];
            arrcopy[maxindex] = temp;
            last--;
        }
        return arrcopy;
    }


    public static int[] insertionSort(int[] arr) {
        int[] arrcopy = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arrcopy.length; i++) {
            int pre = i - 1;
            int curr = arrcopy[i];
            while (pre >= 0 && curr < arrcopy[pre]) {
                arrcopy[pre + 1] = arrcopy[pre];
                pre--;
            }
            arrcopy[pre + 1] = curr;
        }
        return arrcopy;
    }
//  todo  希尔

    //  归并排序
    public static int[] mergeSort(int[] arr, int l, int r, int[] temp) {
        int[] arrcopy = Arrays.copyOf(arr, arr.length);
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arrcopy, l, mid, temp);
            mergeSort(arrcopy, mid + 1, r, temp);
            merge(arrcopy, l, mid, r, temp);
        }
        return arrcopy;
    }

    // 归并排序辅助函数
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) arr[left++] = temp[t++];
    }


    public static int[] quickSort(int[] arr) {
        int[] arrcopy = Arrays.copyOf(arr, arr.length);
        return quickSort(arrcopy, 0, arrcopy.length - 1);
    }

    //    时间复杂度：nlogn
    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int postion = quickSortHelper(arr, low, high);
            quickSort(arr, low, postion - 1);
            quickSort(arr, postion + 1, high);
        }
        return arr;
    }

    private static int quickSortHelper(int[] arr, int low, int high) {
        int pivot = arr[high];
        int slow = low;
//        这个和leetcode 27题目 移除元素有点像，都是和某个元素比较的
        int fast = low;
        while (fast < high) {
            if (arr[fast] <= pivot) {
                int temp = arr[fast];
                arr[fast] = arr[slow];
                arr[slow] = temp;
                slow++;
            }
            fast++;
        }
        int temp = arr[slow];
        arr[slow] = arr[high];
        arr[high] = temp;
        return slow;
    }

    //    假设都是正数
    public static int[] CountingSort(int[] arr) {
        int[] arrcopy = Arrays.copyOf(arr, arr.length);
        int max = Integer.MIN_VALUE;
        for (int i : arrcopy) max = Math.max(max, i);
        return CountingSortHelper(arrcopy, max);
    }

    private static int[] CountingSortHelper(int[] arr, int maxValue) {
        int[] bucket = new int[maxValue + 1];
        int[] res = new int[arr.length];
        for (int i : arr) bucket[i] += 1;
        int count = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                res[count] = i;
                count++;
                bucket[i]--;
            }
        }
        return res;
    }

    public static void RadixSort(int[] arr) {

    }
}
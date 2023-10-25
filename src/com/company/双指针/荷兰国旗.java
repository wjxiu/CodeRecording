package com.company.双指针;

import com.company.公共类.工具类.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiu
 * @create 2023-11-07 12:34
 */
public class 荷兰国旗 {
    static void sortColors1(int[] nums) {
//        p0:[0,p0)为0  p0:(p2,len-1]为2
        int p0 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
//                可以确定交换之后i的值肯定不是0
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 1) {
//                p0-p2之间的值就是1,不用处理
                i++;
            } else {
//               交换之后可以确定右边的值一定是2,但是i可能是0或者1,由于01的处理不同,所以不用i++,留到下一趟处理
                swap(nums, i, p2);
                p2--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}

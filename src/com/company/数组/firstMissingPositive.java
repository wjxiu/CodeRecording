package com.company.数组;

import com.company.公共类.ListNode;
import com.company.公共类.工具类.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiu
 * @create 2023-11-21 17:41
 */
public class firstMissingPositive {
    static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) nums[i] = length;
        }
        for (int i = 0; i < length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs <= length) {
                nums[abs - 1] = -Math.abs(nums[abs - 1]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return length + 1;
    }
}

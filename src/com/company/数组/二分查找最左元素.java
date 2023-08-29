package com.company.数组;

import java.util.HashMap;

/**
 * @author xiu
 * @create 2023-08-28 13:27
 */
public class 二分查找最左元素 {
    public static void main(String[] args) {
        System.out.println(二分查找最左元素.isUnique("as"));
    }


    public static boolean isUnique(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int oddCount = 0;
        for (int value : map.values()) {
            if (value % 2 == 1) {
                oddCount++;
                if (oddCount > 1) return false;
            }
        }
        return true;
    }
    int searchright ( int[] nums, int target){
            int left = 0;
            int right = nums.length - 1;
            int first = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == nums[mid]) {
                    first = mid;
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return first;
        }

    int searchleft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int end = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                end = middle;
                right = middle - 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return end;
    }
}

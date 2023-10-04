package com.company.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @author xiu
 * @create 2023-07-10 14:58
 */
public class 两个数组的交集 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 两个数组的交集().intersection(new int[]{4, 7, 9, 7, 6, 7}, new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4})));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> map = new HashSet<>();
        for(int i:nums1){
            map.add(i);
        }
        for(int i:nums2){
            boolean add = map.contains(i);
            if (add){
                res.add(i);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

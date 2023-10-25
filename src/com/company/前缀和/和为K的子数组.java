package com.company.前缀和;

import java.util.HashMap;

/**
 * @author xiu
 * @create 2023-11-19 19:44
 */
public class 和为K的子数组 {
    static int subarraySum(int[] nums, int k) {
        int pre =0;
        HashMap<Integer,Integer> map=new HashMap<>();int res=0;map.put(0,1);
        for (int num : nums) {
            pre += num;
            map.put(pre, map.getOrDefault(pre, 0) + 1);
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
        }
        return res;
    }
}

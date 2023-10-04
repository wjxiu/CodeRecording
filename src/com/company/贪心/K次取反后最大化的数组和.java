package com.company.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author xiu
 * @create 2023-07-18 10:49
 */
public class K次取反后最大化的数组和 {
    public static void main(String[] args) {
        System.out.println(new K次取反后最大化的数组和().largestSumAfterKNegations1(new int[]{2,-3,-1,5,-4}, 2));

    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        while (k > 0) {
            nums[nums.length - 1] = -nums[nums.length - 1];
            k--;
        }
        return Arrays.stream(nums).sum();
    }


    public int largestSumAfterKNegations1(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
//            优先替换最小的负数
            if (nums[i] < 0&&k>0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        Arrays.sort(nums);
//        如果k还有并且k是奇数，找最小的正数替换
        	if (k % 2 == 1) nums[0] = -nums[0];
        return Arrays.stream(nums).sum();
    }


}

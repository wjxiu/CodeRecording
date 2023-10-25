package com.company.双指针;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-10-20 13:16
 */
public class 最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int[] copyArr= Arrays.copyOf(nums,nums.length);
        Arrays.sort(copyArr);
        int left=Integer.MAX_VALUE;int right=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=copyArr[i]){
                left=i;
                break;
            }
        }
        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i]!=copyArr[i]){
                right=i;
                break;
            }
        }
        return right==Integer.MAX_VALUE&&left==Integer.MAX_VALUE?0: right-left+1;
    }
}

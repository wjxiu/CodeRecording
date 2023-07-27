package company.双指针;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xiu
 * @create 2023-07-27 13:32
 */
public class 长度最小的子数组 {
    public static void main(String[] args) {
        System.out.println(new 长度最小的子数组().minSubArrayLen(7, new int[]{8}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                count=Math.min(count,i-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return count==Integer.MAX_VALUE?0:count;
    }
}

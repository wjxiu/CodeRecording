package company.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-11 11:14
 */
public class 四数之和 {
    public static void main(String[] args) {
        System.out.println(new 四数之和().fourSum1(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0&&nums[i]>target) break;
            if (i>0&&nums[i]==nums[i-1]) continue;

            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
                while (left<right){
                    int sum = nums[i]+nums[j] + nums[left] + nums[right];
                    if (sum ==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right&&nums[left]==nums[left+1]) left++;
                        while (left<right&&nums[right]==nums[right-1]) right--;
                        right--;
                        left++;
                    }else if(sum>target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> fourSum1(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i>0&&nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < nums.length-2; j++) {
//                刚开始是紧挨着不用去重
                if (j>i+1&&nums[j]==nums[j-1]) continue;
                int left=j+1;
                int right=nums.length-1;
                while (left<right){
//                    防止溢出
                    Long sum=Long.valueOf(nums[i])+Long.valueOf(nums[j])+Long.valueOf(nums[left])+Long.valueOf(nums[right]);
                    if (sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right&&nums[left]==nums[left+1]) left++;
                        while (left<right&&nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }else if(sum>target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return result;
    }
}

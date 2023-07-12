package company.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-11 10:49
 */
public class 三数之和 {
    public static void main(String[] args) {
        System.out.println(new 三数之和().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0]>0||nums.length<3) return result;
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum ==0){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    result.add(integers);
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    while (left<right&&nums[right]==nums[right-1]) right--;
                    right--;
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}

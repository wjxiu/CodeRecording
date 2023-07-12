package company.双指针;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-12 14:52
 */
public class 移动零 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,3,2,0,2,3};
        System.out.println(new 移动零().moveZeroes(nums));
        System.out.println(Arrays.toString(nums));
    }
    public int moveZeroes(int[] nums) {
        int slow=0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]==0){
                continue;
            }else{
                nums[slow]=nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < nums.length ; i++) {
            nums[i]=0;
        }
        return slow;
    }
}

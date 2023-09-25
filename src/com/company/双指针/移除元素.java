package company.双指针;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-12 14:19
 */
public class 移除元素 {
    public static void main(String[] args) {
        int[] nums = {3,2,2};
//        System.out.println(new 移除元素().removeElement(nums, 3));
        System.out.println(new 移除元素().removeElement1(nums, 3));
//        System.out.println(Arrays.toString(nums));
    }
    public int removeElement(int[] nums, int val) {
//        快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
//        慢指针：指向更新 新数组下标的位置
        int fast=0;
        int slow=0;
        for (; fast < nums.length; fast++) {
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement1(int[] nums, int val){
        int fast=0;
        int slow=0;
        while (fast<nums.length){
//            跳过需要删除的元素
            if (nums[fast]==val){
                fast++;
            }else{
                nums[slow]=nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }
}

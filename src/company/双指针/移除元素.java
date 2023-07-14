package company.双指针;

import javafx.scene.layout.BackgroundRepeat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-12 14:19
 */
public class 移除元素 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.forEach(i->{
            if (i==4){
                return;
            }
                System.out.println(i);

        });
//        int[] nums = {3,2,2,3};
//        System.out.println(new 移除元素().removeElement(nums, 3));
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
}

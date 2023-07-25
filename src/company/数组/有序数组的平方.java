package company.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author xiu
 * @create 2023-07-09 16:02
 */
public class 有序数组的平方 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 有序数组的平方().sortedSquares1(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new 有序数组的平方().sortedSquares1(new int[]{-7,-3,2,3,11})));
    }
//    双指针
    public int[] sortedSquares(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int[] res = new int[nums.length];
        for (int i = res.length-1; i>=0; i--) {
            int leftnum = nums[left];
            int rightnum = nums[right];
            if (leftnum *leftnum<rightnum*rightnum){
                res[i]=rightnum*rightnum;
                right--;
            }else{
                res[i]=leftnum *leftnum;
                left++;

            }
        }
        return res;
    }

    public int[] sortedSquares1(int[] nums){
        int left=0;
        ArrayList<Integer> res = new ArrayList<>();
        int right=nums.length-1;
        while (left<=right){
           if (nums[left]*nums[left]>nums[right]*nums[right]){
               res.add(nums[left]*nums[left]);
               left++;
           }else{
               res.add(nums[right]*nums[right]);
               right--;
           }
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

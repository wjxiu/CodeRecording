package 数组;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-09 16:02
 */
public class 有序数组的平方 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 有序数组的平方().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
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
}

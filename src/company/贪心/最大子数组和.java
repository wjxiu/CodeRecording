package company.贪心;

/**
 * @author xiu
 * @create 2023-07-17 23:11
 */
public class 最大子数组和 {
    public static void main(String[] args) {
        System.out.println(new 最大子数组和().maxSubArray(new int[]{-1,-2,-3,-4}));
    }
    public int maxSubArray(int[] nums) {
        if (nums.length==1) return nums[0];
        int count=nums[0];
        int sum=count;
        for (int i = 1; i < nums.length; i++) {
            count+=nums[i];
            sum=Math.max(sum,count);
            if (count<0){
                count=nums[i];
            }
        }
        return sum;
    }
}

package 数组;

/**
 * @author xiu
 * @create 2023-07-09 16:18
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int res=Integer.MAX_VALUE;
        int sum=0;
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            while (sum>=target){
                res=Math.min(res,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}

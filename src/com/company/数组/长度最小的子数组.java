package company.数组;

/**
 * @author xiu
 * @create 2023-07-09 16:18
 */
public class 长度最小的子数组 {
    public static void main(String[] args) {
        System.out.println(new 长度最小的子数组().minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new 长度最小的子数组().minSubArrayLen1(11, new int[]{1,2,3,4,5}));
        System.out.println(new 长度最小的子数组().minSubArrayLen1(11, new int[]{1,1,1,1,1,1,1,1}));
    }
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

    public int minSubArrayLen1(int target, int[] nums){
        int left=0;
        int res=0;
        int count=Integer.MAX_VALUE;
        for (int right = 0; right<nums.length;right++) {
            res+=nums[right];
            while (res>=target){
                count=Math.min(count, right-left+1);
                res-=nums[left];
                left++;
            }
        }
        return count==Integer.MAX_VALUE?0: count;
    }
}

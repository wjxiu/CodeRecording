package company.双指针;

import com.company.公共类.工具.LeetCodeUtils;

/**
 * @author xiu
 * @create 2023-08-04 14:57
 */
public class 最大连续1的个数3 {
    public static void main(String[] args) {
        System.out.println(new 最大连续1的个数3().longestOnes(LeetCodeUtils.geneIntArr("[1,1,1,0,0,0,1,1,1,1,0]"), 2));
        System.out.println(new 最大连续1的个数3().findMaxConsecutiveOnes(LeetCodeUtils.geneIntArr("[1,1,0,1,1,1]")));
    }
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int res=-10;
        int count=0;// 记录窗口内0的个数
        while (right< nums.length){
            if (nums[right]==0){
                count++;
            }
            right++;
//            维持窗口的0的个数不大于k
            while(count>k){
//                如果有多余的0，
                if (nums[left]==0){
                    count--;
                }
                left++;
            }
            res=Math.max(res,right-left);
        }
        return res;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0;
        int right=0;
        int res=-1;
        while (right< nums.length){
            if (nums[right]==0){
                left=right+1;
            }
            res=Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}

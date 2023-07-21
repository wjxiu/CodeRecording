package company.动态规划.背包问题.KnapsackProblem;

import java.util.LinkedList;

/**
 * 动态规划不会，这是回溯的解法
 * @author xiu
 * @create 2023-07-20 12:56
 */
public class 目标和 {
    int count = 0;

    public static void main(String[] args) {
        System.out.println(new 目标和().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        back(nums, target, 0, 0);
        return count;
    }
    public void back(int[] nums, int target, int start, int sum) {
        if (start == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        } else {
            back(nums, target, start + 1, sum + nums[start]);
            back(nums, target, start + 1, sum - nums[start]);
        }
    }
}

package company.动态规划;

import java.util.Arrays;

/**
 * 确定dp数组（dp table）以及下标的含义 ：爬到第i个楼梯花费最小的体力为dp[i]
 * 确定递推公式  dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
 * dp数组如何初始化 dp[0]=0; dp[1]=0; 选择cost[0],cost[1]最小费用开始爬
 * 确定遍历顺序 2-cost.length
 * 举例推导dp数组
 * @author xiu
 * @create 2023-07-19 19:27
 */
public class 使用最小花费爬楼梯 {
    public static void main(String[] args) {
        new 使用最小花费爬楼梯().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
    }
    public int minCostClimbingStairs(int[] cost) {
        System.out.println();
        int[] dp = new int[cost.length+1];
        int[] newcost = Arrays.copyOf(cost, cost.length + 1);
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i <newcost.length; i++) {
            dp[i]=Math.min(dp[i-1]+newcost[i-1],dp[i-2]+newcost[i-2]);
        }
        return dp[dp.length-1];
    }
}

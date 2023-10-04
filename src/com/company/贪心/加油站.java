package com.company.贪心;

/**
 * @author xiu
 * @create 2023-07-18 11:09
 */
public class 加油站 {
    public static void main(String[] args) {
        System.out.println(new 加油站().canCompleteCircuit1(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(new 加油站().canCompleteCircuit1(new int[]{2,3,4}, new int[]{3, 4, 3}));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int sum=0;
        int cursum=0;
        for (int i = 0; i < gas.length; i++) {
            sum+=gas[i]-cost[i];
            cursum+=gas[i]-cost[i];
            if (cursum<0){
                start=(i+1)%gas.length;
                cursum=0;
            }
        }
        if (sum<0) return -1;
        return start;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost){
//        获得全部汽油-消耗的全部汽油
        int profitgas =0;
        int remaingas =0;
        int start=0;
        for (int i = 0; i < gas.length; i++) {
            profitgas +=gas[i]-cost[i];
            remaingas +=gas[i]-cost[i];
            if (remaingas <0){
                start=i+1;
                remaingas =0;
            }
        }
        if (profitgas <0) return -1;
        return  start;
    }
}

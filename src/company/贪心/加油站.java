package company.贪心;

import java.util.stream.IntStream;

/**
 * @author xiu
 * @create 2023-07-18 11:09
 */
public class 加油站 {
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
}

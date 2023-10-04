package com.company.贪心.区间问题;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-18 17:03
 */
public class 无重叠区间 {
    public static void main(String[] args) {
        int[][] ints = {
//                [[10,16],[2,8],[1,6],[7,12]]
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        System.out.println(new 无重叠区间().eraseOverlapIntervals(ints));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if (a[1]==b[1]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
//        记录非重叠区间个数，如果只有一个，那么自己和自己肯定不重叠，初始化为1
        int count=1;
        int end=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>=end){
                end=intervals[i][1];
                count++;
            }
        }
        return intervals.length-count;
    }



    public int eraseOverlapIntervals1(int[][] intervals){
        Arrays.sort(intervals,(i,i1)->{
            if (i[0]==i1[0]){
                return  Integer.compare(i[1],i1[1]);
            }
            return  Integer.compare(i[0],i1[0]);
        });
        int count=1;
//        不懂为什么不能用end记录，要用intervals[i]记录
//        int end=intervals[0][1];
        for (int i = 1; i <intervals.length; i++) {
            if (intervals[i][0]<intervals[i-1][1]){
                count++;
                intervals[i][1]=Math.min(intervals[i-1][1],intervals[i][1]);
            }
        }
        return intervals.length-count;
    }
}

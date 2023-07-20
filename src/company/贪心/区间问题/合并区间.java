package company.贪心.区间问题;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xiu
 * @create 2023-07-19 12:25
 */
public class 合并区间 {
    public static void main(String[] args) {
        int[][] merge = new 合并区间().merge(new int[][]{{1, 4}, {0, 4}});
        System.out.println(Arrays.deepToString(merge));
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            else
                return Integer.compare(a[0], b[0]);
        });
        System.out.println(Arrays.deepToString(intervals));
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.getLast();
            if(last[1]>=intervals[i][0]){
                last[1]=Math.max(intervals[i][1],last[1]);
            }else{
                res.add(intervals[i]);
            }
        }
        int[][] arrres = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            int[] ints = res.get(i);
            arrres[i]=ints;
        }
        return arrres;
    }
}

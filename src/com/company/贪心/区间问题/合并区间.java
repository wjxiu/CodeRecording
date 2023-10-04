package com.company.贪心.区间问题;

import com.company.公共类.工具类.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xiu
 * @create 2023-07-19 12:25
 */
public class 合并区间 {
    public static void main(String[] args) {
        int[][] ints = LeetCodeUtils.parseToIntArray(" [[1,4],[4,5]]");
        int[][] merge = new 合并区间().merge1(ints);
        System.out.println(Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else
                return Integer.compare(a[0], b[0]);
        });
        System.out.println(Arrays.deepToString(intervals));
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.getLast();
            if (last[1] >= intervals[i][0]) {
                last[1] = Math.max(intervals[i][1], last[1]);
            } else {
                res.add(intervals[i]);
            }
        }
        int[][] arrres = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            int[] ints = res.get(i);
            arrres[i] = ints;
        }
        return arrres;
    }

    public int[][] merge1(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (i, i1) -> {
            if (i[0] == i1[0]) return Integer.compare(i[1], i1[1]);
            return Integer.compare(i[0], i1[0]);
        });
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = list.get(list.size() - 1);
            if (intervals[i][0] <= ints[1]) {
                ints[1] = Math.max(intervals[i][1], ints[1]);
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[][]{});
    }
}

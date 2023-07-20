package company.贪心.区间问题;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-18 16:19
 */
public class 用最少数量的箭引爆气球 {
    public static void main(String[] args) {
        int[][] ints = {
//                [[10,16],[2,8],[1,6],[7,12]]
                {-2147483646, -2147483645},
                {2147483646, 2147483647},
        };
        new 用最少数量的箭引爆气球().findMinArrowShots(ints);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
//            防止溢出
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        int arrow = 1;
        for (int i = 0; i < points.length - 1; i++) {
//            当前的右边界<下一个的左边界，不重叠，箭头+1
            if (points[i][1] < points[i + 1][0]) {
                arrow++;
            } else {
                points[i + 1][1] = Math.min(points[i][1], points[i + 1][1]);
            }
        }
        System.out.println(arrow);
        return arrow;
    }
}

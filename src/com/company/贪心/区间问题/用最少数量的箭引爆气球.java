package company.贪心.区间问题;

import com.company.公共类.工具类.LeetCodeUtils;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-18 16:19
 */
public class 用最少数量的箭引爆气球 {
    public static void main(String[] args) {
//        int[][] ints = {
//                [[10,16],[2,8],[1,6],[7,12]]
//                {-2147483646, -2147483645},
//                {2147483646, 2147483647},
//        };
        int[][] ints = LeetCodeUtils.parseToIntArray("[[-2147483646,-2147483645],[2147483646,2147483647]]");
        System.out.println(new 用最少数量的箭引爆气球().findMinArrowShots1(ints));
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

    public int findMinArrowShots1(int[][] points){
        Arrays.sort(points,(i,i1)->{
            if (i[0]==i1[0]) return Long.compare(i[1],i1[1]);
            return Long.compare(i[0],i1[0]);
        });
        int count=1;
        int right=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]>right){
                count++;
                right=points[i][1];
            }else{
                right=Math.min(right,points[i][1]);
            }
            System.out.println(Arrays.deepToString(points));
        }
        return count;
    }
}

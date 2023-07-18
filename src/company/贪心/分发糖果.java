package company.贪心;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-18 13:28
 */
public class 分发糖果 {
    public static void main(String[] args) {
        new 分发糖果().candy(new int[]{1,3,2,2,1});
    }
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res,1);
//        比较左边的
        for (int i = 1; i < ratings.length ; i++) {
            if (ratings[i]>ratings[i-1]){
                res[i]=res[i-1]+1;
            }
        }
//        比较右边的孩子，如果是从左到右遍历，右边孩子还没有确定糖果数量就确定自己的数量，如果右边孩子的糖果数发生变化，
//        那么之前左边确定下来的就是错的
//        所以要先确定右边的再确定左边的，也就是从右往左遍历
        for (int i = ratings.length-2;  i >=0 ; i--) {
            if (ratings[i]>ratings[i+1]){
                res[i]=Math.max(res[i],res[i-1]+1);
            }
        }
        int sum=0;
        for(int i:res){
            sum+=i;
        }
        System.out.println(Arrays.toString(res));
        return sum;
    }
}

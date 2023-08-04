package company.贪心;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-18 13:28
 */
public class 分发糖果 {
    public static void main(String[] args) {
        System.out.println(new 分发糖果().candy1(new int[]{1,2,2}));
        System.out.println(new 分发糖果().candy1(new int[]{1,0,2}));
        System.out.println(new 分发糖果().candy1(new int[]{1,3,2,2,1}));
        System.out.println(new 分发糖果().candy1(new int[]{1,3,4,5,2}));
    }
    public int candy1(int[] ratings){
        int[] res = new int[ratings.length];
        Arrays.fill(res,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]){
                res[i]=Math.max(res[i-1]+1,res[i]);
            }
        }
        for (int i = ratings.length-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1]){
                res[i]=Math.max(res[i+1]+1,res[i]);
            }
        }
        System.out.println(Arrays.toString(res));
        return Arrays.stream(res).sum();
    }

}

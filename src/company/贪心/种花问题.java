package company.贪心;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-08-01 14:23
 */
public class 种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        int[] flower = new int[flowerbed.length + 2];
        for (int i = 1; i < flowerbed.length; i++) {
            flower[i]=flowerbed[i];
        }
        System.out.println(Arrays.toString(flower));
        flower[0]=0;
        flower[flower.length-1]=0;
        for (int i = 1; i < flower.length-1; i++) {
            if (flower[i-1]==0&&flower[i]==0&&flower[i+1]==0){
                flower[i]=1;
                count++;
            }
        }
        return count>=n;
    }
}

package com.company.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xiu
 * @create 2023-11-01 14:46
 */
public class 交换和 {
    public static void main(String[] args) {
        System.out.println('0'-'0');
        System.out.println(Arrays.toString(new 交换和().findSwapValues(new int[]{1,2,3}, new int[]{4,5,6})));
    }
    public int[] findSwapValues(int[] arraya, int[] arrayb) {
        int suma = Arrays.stream(arraya).sum();
        int sumb = Arrays.stream(arrayb).sum();
        if ((sumb+suma)%2==1)return new int[0];
        HashSet<Integer> map = new HashSet<>();
        for(int b:arrayb){
            map.add(b);
        }
        for(int a: arraya){
           int b= (sumb-suma)/2+a;
            if (map.contains(b)){
                return new int[]{a,b};
            }
        }
        return new int[0];
    }
}

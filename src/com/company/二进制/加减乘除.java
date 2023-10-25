package com.company.二进制;

/**
 * @author xiu
 * @create 2023-11-01 18:48
 */
public class 加减乘除 {
    static int add(int x, int y) {
        int carry=0;
        while (y != 0) {
            x = x ^ y;
            carry = x & y;
            y = carry << 1;
        }
        return x;
    }
    static int minus(int x, int y) {
//        add(~y, 1):取反
        return add(x, add(~y, 1));
    }

    static int multiply(int x, int y) {
        int res = 0;
        while (y != 0) {
            if ((y & 1) != 0) res = add(x, res);
            x = x << 1;
            y = y >> 1;
        }
        return res;
    }

    static int divide(int x, int y) {
        int a = x < 0 ? minus(0, x) : x;
        int b = y < 0 ? minus(0, y) : y;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((a >> i) >= b) {
                res |= (1 << i);
                a = minus(a, b << i);
            }
        }
        return x < 0 ^ y < 0 ? minus(0, res) : res;
    }
    public int divide1(int dividend, int divisor) {
       int dividend1=Math.abs(dividend);
       int divisor1=Math.abs(divisor);
        int count=0;
        while (dividend1>divisor1){
            dividend1-=divisor1;
            count++;
        }
        return dividend<0||divisor<0?-count:count;
    }
}

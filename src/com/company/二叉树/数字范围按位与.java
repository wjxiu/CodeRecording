package com.company.二叉树;

/**
 * @author xiu
 * @create 2023-11-10 20:00
 */
public class 数字范围按位与 {
    static int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }
}

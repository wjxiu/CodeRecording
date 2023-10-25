package com.company.数组;

import com.company.公共类.ListNode;
import com.company.公共类.工具类.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 上下对称：matrix[i][j] -> matrix[n-i-1][j]，（列不变）
 * 左右对称：matrix[i][j] -> matrix[i][n-j-1]，（行不变）
 * 主对角线对称：matrix[i][j] -> matrix[j][i]，（行列互换）
 * 副对角线对称：matrix[i][j] -> matrix[n-j-1][n-i-1] （行列均变，且互换）
 * 链接：https://leetcode.cn/problems/rotate-image/solutions/1692273/lu-qing-ge-chong-by-pennx-ce3x/
 *
 * @author xiu
 * @create 2023-11-06 16:23
 */
public class 旋转数组 {
    static void rotate(int[][] matrix) {
        int m = matrix.length;
//        主对角线翻转
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
//        左右翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                swap(matrix, i, j, i, m - j - 1);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    static void swap(int[][] matrix, int a, int b, int x, int y) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[x][y];
        matrix[x][y] = temp;
    }


    static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null) {
            count++;
            fast = fast.next;
        }
        int n = k % count;
        if (n == 0) return head;
        fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (n <= 0) {
                slow = slow.next;
            }
            n--;
        }
        ListNode newhead = slow.next;
        slow.next = null;
        ListNode temp = newhead;
        while (temp.next != null) temp = temp.next;
        temp.next = head;
        return newhead;
    }




}

package com.company.随机数;

import com.company.公共类.ListNode;

import java.time.temporal.Temporal;
import java.util.Random;

/**
 * @author xiu
 * @create 2023-10-24 10:51
 */
public class 池塘抽样 {
    public static void main(String[] args) {
        池塘抽样 池塘抽样 = new 池塘抽样(ListNode.geneList(10,1,10,20,100));
        for (int i = 0; i < 100; i++) {
            System.out.println(池塘抽样.getRandom());
        }
    }

    ListNode head;
    int k;
    Random random;

    public 池塘抽样(ListNode head) {
        k = 1;
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int[] res = new int[k];
        ListNode tree = head;
        int count = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = tree.val;
            tree = tree.next;
            count++;
        }
        while (tree != null) {
            int i = random.nextInt(count+1);
            if (i < k) {
                res[i] = tree.val;
            }
            count += 1;
            tree = tree.next;
        }
        return res[random.nextInt(k)];
    }
}

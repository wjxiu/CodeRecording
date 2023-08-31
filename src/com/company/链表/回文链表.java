package com.company.链表;

import company.公共类.ListNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * @author xiu
 * @create 2023-08-31 11:09
 */
public class 回文链表 {
    public static void main(String[] args) {
        System.out.println(new 回文链表().isPalindrome(ListNode.geneList(1, 2, 1, 2, 2)));

    }

    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return next(head);
    }

    //    利用递归特性找到链表末端，并且和前端比较
    public boolean next(ListNode head) {
        if (head == null) return true;
        boolean next = next(head.next);
        if (!next) return false;
        if (frontPointer.val != head.val) return false;
        frontPointer = frontPointer.next;
        return true;
    }

    //使用栈
    public boolean isPalindromeStack(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ListNode x=head;
        while (x!=null){
            stack.push(x.val);
            x=x.next;
        }
        x=head;
        while (x!=null){
            if (x.val!=stack.pop()) return false;
            x=x.next;
        }
        return true;
    }


}

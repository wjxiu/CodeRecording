package com.company.链表;

import company.公共类.ListNode;

import java.util.ArrayDeque;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * @author xiu
 * @create 2023-08-31 11:09
 */
public class 回文链表 {
    public static void main(String[] args) {
        System.out.println(new 回文链表().middleNode(ListNode.geneList()));

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
        ListNode x = head;
        while (x != null) {
            stack.push(x.val);
            x = x.next;
        }
        x = head;
        while (x != null) {
            if (x.val != stack.pop()) return false;
            x = x.next;
        }
        return true;
    }

    //    第三种解法（最优解）
//    使用反转后面一半链表，和前面一半链表比较
//    为什么不是反转前面一边，因为反转后半段简单一点
    public boolean isPalindromeBest(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode middle = middleNode(head);
        ListNode after = iterativeReverseList(middle);
        middle.next=after;
        ListNode a=after;
        while (head!=middle){
            if (head.val!= a.val) return false;
            head=head.next;
            a=a.next;
        }
        return true;
    }

//    找到中间点
    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
//反转链表
    private ListNode iterativeReverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur =head;
        while (cur !=null){
            ListNode tem= cur.next;
            cur.next=pre;
            pre= cur;
            cur =tem;
        }
        return pre;
    }

}
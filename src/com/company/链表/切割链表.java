package com.company.链表;

import com.company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-11-24 16:22
 */
public class 切割链表 {
    //    如果是偶数,返回中心的第一个节点
    //    ListNode fast = head.next; fast的位置是关键
    static ListNode cutforfirst(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //    如果是偶数,返回中心的第二个节点
//    ListNode fast = head; fast的位置是关键
    static ListNode cutforsecond(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

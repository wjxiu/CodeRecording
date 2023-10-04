package com.company.链表;

import com.company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-10 11:11
 */
public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        System.out.println(new 两两交换链表中的节点().swapPairs2(
                ListNode.geneList(1,2,3)));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode listNode = swapPairs(head.next.next);
        next.next = head;
        head.next = listNode;
        return next;
    }

    //递归 1,2,3,4,5,6,7,8,9
//     2,1 4,3 6,5 8,7,9
    public ListNode swapPairs1(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode temp = head.next.next;
        ListNode next = head.next;
        head.next.next = head;
        head.next = swapPairs1(temp);
        return next;
    }
    public ListNode swapPairs2(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode next = head.next;
        ListNode listNode = swapPairs2(next.next);
        next.next=head;
        head.next=listNode;
        return next;
    }

}

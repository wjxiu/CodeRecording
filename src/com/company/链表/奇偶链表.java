package com.company.链表;

import com.company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-11-13 15:15
 */
public class 奇偶链表 {
    static ListNode oddEvenListSplit(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode oddlast = dummy;
        ListNode temp = dummy;
        while (temp != null && temp.next != null) {
            ListNode remove = temp.next;
            if (temp.next.val % 2 == 1) {
                temp.next = temp.next.next;
                remove.next = oddlast.next;
                oddlast.next = remove;
                oddlast = oddlast.next;
            }
            temp = remove;
        }
        return dummy.next;
    }

    static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode even=head.next;
        ListNode oddlast= head;
        ListNode evenlast=even;
        while(evenlast!=null&&evenlast.next!=null){
            oddlast.next=evenlast.next;
            oddlast=oddlast.next;
            evenlast.next=oddlast.next;
            evenlast=evenlast.next;
        }
        oddlast.next=even;
        return head;
    }
}

package com.company.链表;
import company.公共类.ListNode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author xiu
 * @create 2023-08-31 12:07
 */
public class 环路检测 {
    public static void main(String[] args) {

    }
    public ListNode detectCycleTwoPointer(ListNode head){
        ListNode dummy=new ListNode(-1,head);
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                slow=head;
                while (fast!=slow){
                    slow=slow.next;
                    fast=fast.next;
                }
            }
        }

        return null;
    }

    public ListNode detectCycleSet(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (!set.add(head)) {
                return head;
            }
            head=head.next;
        }
        return null;
    }
}

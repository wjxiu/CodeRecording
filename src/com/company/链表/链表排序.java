package com.company.链表;

import company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-10-04 15:59
 */
public class 链表排序 {
    public static void main(String[] args) {
        ListNode listNode = new 链表排序().sortList(ListNode.geneList(-1,5,3,4,0));
        System.out.println(listNode);
    }
//    使用归并排序
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode newhead = new ListNode();
        ListNode temp1=newhead;
        while (left !=null&& right !=null){
             if (right.val> left.val){
                temp1.next= left;
                 left = left.next;
            }else{
                temp1.next= right;
                 right = right.next;
            }
            temp1=temp1.next;
        }
        temp1.next= right ==null? left : right;
        return newhead.next;
    }
}

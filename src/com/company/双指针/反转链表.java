package com.company.双指针;

import com.company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-13 10:12
 */
public class 反转链表 {
    public static void main(String[] args) {
        System.out.println(new 反转链表().reverseList1(ListNode.geneList(1, 2, 3, 4, 5, 6)));
        System.out.println(new 反转链表().reverseBetween(ListNode.geneList(1, 2, 3, 4, 5, 6),2,6));
    }
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }


    public ListNode reverseList1(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cur =head;
       ListNode pre=null;
       while (cur !=null){
           ListNode temp= cur.next;
           cur.next=pre;
           pre= cur;
           cur =temp;
       }
       return pre;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode temp=dummy;
        ListNode pre=null;
        for (int i = 0; i < left; i++){
            pre=temp;
            temp=temp.next;
        }
        ListNode rightnode = temp;
        for (int i = left; i < right; i++) {
            rightnode=rightnode.next;
        }
        ListNode leftNode=pre.next;
        ListNode curr=rightnode.next;
        pre.next=null;
        rightnode.next=null;
        pre.next= reverseList(leftNode);
        leftNode.next=curr;
        return dummy.next;
    }

}

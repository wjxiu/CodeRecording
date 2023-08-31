package com.company.链表;
import company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-08-31 10:33
 */
public class 分割链表 {
    public static void main(String[] args) {
        System.out.println(new 分割链表().partition(ListNode.geneList(1,4,3,2,5,2), 3));
    }
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(-1);
        ListNode scur=small;
        ListNode bigger =new ListNode(-1);
        ListNode bcur=bigger;
        ListNode cur=head;
        while (cur!=null){
            if (cur.val>=x){
                bcur.next=new ListNode(cur.val);
                bcur=bcur.next;
            }else{
                scur.next=new ListNode(cur.val);
                scur=scur.next;
            }
            cur=cur.next;
        }
        scur.next=bigger.next;
        return small.next;
    }
}

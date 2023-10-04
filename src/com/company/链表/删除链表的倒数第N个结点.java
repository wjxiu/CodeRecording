package com.company.链表;
import com.company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-10 13:37
 */
public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.geneList(1, 2, 3, 4, 5, 6);
        删除链表的倒数第N个结点 t = new 删除链表的倒数第N个结点();
        for (int i = 1; i <=6; i++) {
            System.out.println(t.removeNthFromEnd2(ListNode.geneList(1, 2, 3, 4, 5, 6), i));
        }}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        for (int i = 0; i <= n; i++) {
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        int count=0;
        while (fast.next!=null){
            if (count<n){
                fast=fast.next;
            }else{
                fast=fast.next;
                slow=slow.next;
            }
            count++;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }

    //演示图https://github.com/wjxiu/photo/blob/main/image.png?raw=true
    public ListNode removeNthFromEnd2(ListNode head, int n){
        if (head==null) return null;
        ListNode listNode=new ListNode(0,head);
        ListNode right=head;
        ListNode left=listNode;
        for (int i = 0; i <n; i++) right=right.next;
        while (right!=null){
            right=right.next;
            left=left.next;
        }
        left.next=left.next.next;
        return listNode.next;
    }

}

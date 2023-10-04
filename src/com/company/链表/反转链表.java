package company.链表;

import company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-10 10:52
 */
public class 反转链表 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.geneList(1,2,3);
        System.out.println(new 反转链表().reverseList2(listNode));
    }
    public ListNode reverseList(ListNode head) {
//        双指针
        ListNode temp=head;
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            cur.next=temp;
            cur.next=pre;
            pre=cur;
            cur=temp;

        }
        return pre;
    }
    public ListNode reverseList1(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }


    public ListNode reverseList2(ListNode head){
        ListNode pre=null;
        ListNode temp=head;
        while (temp!=null){
           ListNode next= temp.next;
           temp.next=pre;
           pre=temp;
           temp=next;
        }
        return pre;
    }
}

package com.company.链表;

import company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-08-31 10:47
 */
public class 链表求和 {
    //    简单版，但是不整洁
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        进位
        int next = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode dcur = dummy;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + next;
            if (sum > 9) {
                next = 1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
            dcur.next = new ListNode(sum % 10);
            dcur = dcur.next;
        }
        while (cur1 != null) {
            int sum = cur1.val + next;
            if (sum > 9) {
                next = 1;
            }
            dcur.next = new ListNode(sum % 10);
            cur1 = cur1.next;
            dcur = dcur.next;

        }
        while (cur2 != null) {
            int sum = cur2.val + next;
            if (sum > 9) {
                next = 1;
            }
            dcur.next = new ListNode(sum % 10);
            cur2 = cur2.next;
            dcur = dcur.next;

        }
        return dummy.next;
    }

    //简洁版
    public ListNode addTwoNumbersgrace(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode dcur = dummy;
        int t=0;
//        t!=0防止最后还要进位
        while (l1!=null||l2!=null||t!=0){
            int sum=t;
            if (l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            dcur.next=new ListNode(sum%10);
            dcur=dcur.next;
            t=sum/10;
        }
        return dummy.next;
    }


}

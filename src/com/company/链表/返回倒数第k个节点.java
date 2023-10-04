package com.company.链表;
import com.company.公共类.ListNode;
/**
 * @author xiu
 * @create 2023-08-30 23:59
 */
public class 返回倒数第k个节点 {
    public static void main(String[] args) {
        System.out.println(new 返回倒数第k个节点().kthToLast(ListNode.geneList(1, 2), 1));
    }
    public int kthToLast(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            if (k>0){
                fast=fast.next;
            }else{
                fast=fast.next;
                slow=slow.next;
            }
            k--;
        }
        return slow.val;
    }
}

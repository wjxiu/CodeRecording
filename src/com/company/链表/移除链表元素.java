package company.链表;

import company.公共类.ListNode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xiu
 * @create 2023-07-09 16:52
 */
public class 移除链表元素 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.geneList(1,2,3,3,3,4);
        System.out.println(new 移除链表元素().removeElements1(listNode, 3));
    }
//    添加虚拟头节点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode temp = dummy;
        while (temp.next!=null){
            if (temp.next.val==val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return dummy.next;
    }
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode temp=dummy;
        while (temp!=null){
            if (temp.val==val){
                pre.next=temp.next;
            }else{
                pre=temp;
            }
            temp=temp.next;

        }
        return dummy.next;
    }




}

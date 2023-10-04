package com.company.链表;

import com.company.公共类.ListNode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xiu
 * @create 2023-07-09 16:52
 */
public class 移除链表元素 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.geneList(3,3,3,3);
        System.out.println(new 移除链表元素().removeElements2(listNode, 3));
    }

    //    添加虚拟头节点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode temp = dummy;
        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
            } else {
                pre = temp;
            }
            temp = temp.next;

        }
        return dummy.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode listNode = new ListNode();
        listNode.next = head;
        ListNode pre = listNode;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
            }else{
                pre = pre.next;
            }
           temp = temp.next;
        }
        return listNode.next;
    }


}

package com.company.链表;


import com.company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-10 10:08
 */
public class MyLinkedList {
//    没写出来
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtIndex(0,1);
//        myLinkedList.addAtIndex(0,2);
//        myLinkedList.addAtIndex(0,3);
//        myLinkedList.addAtTail(1);
//        myLinkedList.addAtTail(1);
//        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(4);
        System.out.println(myLinkedList);
        myLinkedList.deleteAtIndex(0);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1,2);
//        myLinkedList.get(1);
//        myLinkedList.deleteAtIndex(1);
//        myLinkedList.get(1);
        System.out.println(myLinkedList);
    }
    int size;
    ListNode dummy;
    public MyLinkedList() {
        size=0;
        dummy=new ListNode(-1);
    }

    public int get(int index) {
        if (index>size||index<0) return -1;
        ListNode temp=dummy.next;
        int count=0;
        while (temp!=null){
            if (count==index) return temp.val;
            count++;
            temp=temp.next;
        }
        return -1;
    }
//void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next=dummy.next;
        dummy.next=listNode;
        size++;
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
//        ListNode temp=dummy.next;
//        ListNode pre=dummy;
//        while (temp!=null){
//            pre=temp;
//            temp=temp.next;
//        }
//        pre.next=new ListNode(val);
//        size++;

    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        if (index==0){
            addAtHead(val);
            return;
        }
        ListNode pred = dummy;
        for (int i = 0; i < index; i++) {
            pred=pred.next;
        }
        ListNode listNode = new ListNode(val);
        listNode.next=pred.next;
        pred.next= listNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            dummy = dummy.next;
            return;
        }
        ListNode pre=dummy;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        pre.next=pre.next.next;
        size--;
    }

    @Override
    public String toString() {
        ListNode listNode = this.dummy.next;
        StringBuilder sb = new StringBuilder();
        while (listNode!=null){
            sb.append(listNode.val).append("->");
            listNode=listNode.next;
        }
        return sb.toString().equals("") ?"":sb.substring(0,sb.length()-2);
    }
}

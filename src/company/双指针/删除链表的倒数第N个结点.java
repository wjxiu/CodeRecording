package company.双指针;

import company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-13 10:32
 */
public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
        listNode.next=listNode1;
//        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
        new 删除链表的倒数第N个结点().removeNthFromEnd(listNode,1);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode slow =dummy;
        ListNode fast =head;
        for (int i = 0; i <n; i++) {
            if (fast!=null){
                fast = fast.next;
            }
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}

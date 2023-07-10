package company.链表;

import company.ListNode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xiu
 * @create 2023-07-09 16:52
 */
public class 移除链表元素 {
    volatile  int a= 1;
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getYear());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy  MM  dd HH:mm:ss");
        System.out.println(formatter.format(now));
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        new 移除链表元素().removeElements(listNode, 3);
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

}

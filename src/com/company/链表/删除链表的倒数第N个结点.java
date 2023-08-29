package company.链表;
import company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-10 13:37
 */
public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        System.out.println(new 删除链表的倒数第N个结点().removeNthFromEnd1(ListNode.geneList(1, 2, 3, 4, 5, 6), 6));
        System.out.println(new 删除链表的倒数第N个结点().removeNthFromEnd1(ListNode.geneList(1, 2, 3, 4, 5, 6), 5));
        System.out.println(new 删除链表的倒数第N个结点().removeNthFromEnd1(ListNode.geneList(1, 2, 3, 4, 5, 6), 4));
        System.out.println(new 删除链表的倒数第N个结点().removeNthFromEnd1(ListNode.geneList(1, 2, 3, 4, 5, 6), 3));
        System.out.println(new 删除链表的倒数第N个结点().removeNthFromEnd1(ListNode.geneList(1, 2, 3, 4, 5, 6), 2));
        System.out.println(new 删除链表的倒数第N个结点().removeNthFromEnd1(ListNode.geneList(1, 2, 3, 4, 5, 6), 1));
    }
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

}

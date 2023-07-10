package company.链表;

/**
 * @author xiu
 * @create 2023-07-10 11:11
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){return head;}
        ListNode next=head.next;
        ListNode listNode = swapPairs(head.next.next);
        next.next=head;
        head.next=listNode;
        return next;
    }
}

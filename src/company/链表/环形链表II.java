package company.链表;

/**
 * @author xiu
 * @create 2023-07-10 14:18
 */
public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
//        相遇的的时候,慢指针回到链表头部,一起遍历
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                slow=head;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

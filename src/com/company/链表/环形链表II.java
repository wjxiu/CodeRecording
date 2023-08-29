package company.链表;

import company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-10 14:18
 */
public class 环形链表II {
//    错误写法
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
//正确写法
    public ListNode detectCycle1(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (slow!=null&&fast!=null){
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

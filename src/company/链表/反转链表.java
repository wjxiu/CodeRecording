package company.链表;

/**
 * @author xiu
 * @create 2023-07-10 10:52
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
//        双指针
        ListNode temp=head;
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            cur.next=temp;
            cur.next=pre;
            pre=cur;
            cur=temp;

        }
        return pre;
    }
}

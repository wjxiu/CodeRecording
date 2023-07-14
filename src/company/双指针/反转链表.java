package company.双指针;

import company.ListNode;

/**
 * @author xiu
 * @create 2023-07-13 10:12
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}

package company.链表;

/**
 * @author xiu
 * @create 2023-07-10 13:48
 */
public class 链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempa=headA;
        ListNode tempb=headB;
        while (tempa!=tempb){
            if (tempa==null){
                tempa=headB;
            }else{
                tempa=tempa.next;
            }
            if (tempb==null){
                tempb=headA;
            }else{
                tempb=tempb.next;
            }
        }
        return tempa;
    }
}

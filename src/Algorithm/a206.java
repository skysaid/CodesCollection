package Algorithm;



public class a206 {
//    反转一个单链表。


//    public ListNode reverseList(ListNode head) {
//        if (head==null||head.next==null)return head;
//        ListNode next =reverseList(head.next);
//        head.next.next=head;
//        head.next=null;
//        return next;
//    }

    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode cur=head;
        ListNode next =head.next;
        ListNode before =null;
        while (next!=null){
            next=cur.next;
            cur.next=before;
            before=cur;
            cur=next;
        }
        return before;
    }



}

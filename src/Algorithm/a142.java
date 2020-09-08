package Algorithm;

public class a142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast)break;
        }
        System.out.println(slow.val);
        if (fast==null||fast.next==null)return null;
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

}

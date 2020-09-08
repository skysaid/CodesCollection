package Algorithm;


//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class a21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null)return l1;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (l1!=null||l2!=null){
            if (l1==null){
                cur.next=l2;
                return dummy.next;
            }else if (l2==null){
                cur.next=l1;
                return dummy.next;
            }else {
                if (l1.val<l2.val){
                    cur.next=l1;
                    l1=l1.next;
                }else {
                    cur.next=l2;
                    l2=l2.next;
                }
                cur=cur.next;
            }
        }
        return dummy.next;

    }
}

package Algorithm;

public class a2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count=0;
        if (l1==null)return l2;
        if (l2==null)return l1;
        ListNode res=new ListNode(-1);
        ListNode cur=res;
        while (l1!=null||l2!=null){
            int x=(l1==null)?0:l1.val;
            int y=(l2==null)?0:l2.val;
            int temp=x+y+count;
            if (temp>=10){
                count=1;
                temp=temp-10;
            }else {
                count=0;
            }
            cur.next=new ListNode(temp);
            cur=cur.next;
            l1=(l1==null)?null:l1.next;
            l2=(l2==null)?null:l2.next;
            }
        if (count!=0){
            cur.next=new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        System.out.println(1l/10);
    }
}

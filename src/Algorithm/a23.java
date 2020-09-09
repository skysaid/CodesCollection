package Algorithm;


import java.util.PriorityQueue;

public class a23 {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length==0)return null;
//        ListNode dummy=new ListNode(-1);
//        ListNode cur=dummy;
//        PriorityQueue<ListNode> queue=new PriorityQueue<>((a,b)->a.val-b.val);
//        for (int i=0;i<lists.length;i++){
//            ListNode temp=lists[i];
//            while(temp!=null){
//                queue.add(temp);
//                ListNode now=temp;
//                temp=temp.next;
//                now.next=null;
//            }
//        }
//        while (!queue.isEmpty()){
//            cur.next=queue.poll();
//            cur=cur.next;
//        }
//        return dummy.next;
//    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0)return null;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        PriorityQueue<ListNode> queue=new PriorityQueue<>((a,b)->a.val-b.val);
        for (int i=0;i<lists.length;i++){
            if (lists[i]!=null)queue.add(lists[i]);
        }
        while (!queue.isEmpty()){
            ListNode min=queue.poll();
            cur.next=min;
            if (min.next!=null)queue.add(min.next);
            cur=cur.next;
        }
        return dummy.next;
    }
}

package Algorithm;

import java.util.List;

//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
public class a148 {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null)return head;
        int len=0;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        cur.next=head;
        for (;cur!=null;len++,cur=cur.next);


        for (int size=1;size<len;size*=2){
            cur=dummy;
            for (int index=0;index+size<len;index+=2*size){
                ListNode first=cur.next,second=first;
                for (int i=0;i<size-1;i++)second=second.next;
                ListNode temp=second;
                second=second.next;
                temp.next=null;
                ListNode newhead=new ListNode(0);
                int left=0,right=0;
                while (left<size&&right<size&&second!=null){
                    if (first.val<second.val){
                        cur.next=first;
                        first=first.next;
                        left++;
                    }else {
                        cur.next=second;
                        second=second.next;
                        right++;
                    }
                    cur=cur.next;
                }
                while (left<size){
                    cur.next=first;
                    cur=cur.next;
                    first=first.next;
                    left++;
                }
                while (right<size&&second!=null){
                    cur.next=second;
                    cur=cur.next;
                    second=second.next;
                    right++;
                }
                cur.next=second;
            }
        }
        return dummy.next;
    }
//    非常熟空间复杂度
//    public ListNode sortList(ListNode head) {
//        if (head==null||head.next==null)return head;
//        ListNode fast = head.next;
//        ListNode slow = head;
//        while (fast!=null && fast.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        ListNode temp=slow.next;
//        slow.next=null;
//
//        ListNode left=sortList(head);
//        ListNode right=sortList(temp);
//        System.out.println(left.val);
//        System.out.println(right.val);
//        ListNode ans=new ListNode(-1);
//        ListNode cur=ans;
//
//        while (left!=null&&right!=null){
//            if (left.val<right.val){
//                cur.next=left;
//                left=left.next;
//            }else {
//                cur.next=right;
//                right=right.next;
//            }
//            cur=cur.next;
//        }
//        cur.next=(left==null)?right:left;
//        return ans.next;
//    }
}

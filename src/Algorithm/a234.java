package Algorithm;

import java.util.ArrayList;

//请判断一个链表是否为回文链表。
public class a234 {
//    private ListNode frontNode;
//    public boolean isPalindrome(ListNode head) {
////        if (head==null)return true;
////        //使用一个数组来存链表的位置和值
////        ArrayList<Integer> listnodes= new ArrayList<>();
////        ListNode cur=head;
////        while (cur!=null){
////            listnodes.add(cur.val);
////            cur=cur.next;
////        }
////        int len=listnodes.size();
////        for (int i=0;i<len/2;i++){
////            if (!listnodes.get(i).equals(listnodes.get(len-i-1)))return false;
////        }
////        return true;
//        frontNode=head;
//        return helper(head);
//    }
//
//    public boolean helper(ListNode head){
//        if (head==null)return true;
//        if (!helper(head.next))return false;
//        if (frontNode.val!=head.val)return false;
//        frontNode=frontNode.next;
//        return true;
//    }

public boolean isPalindrome(ListNode head) {
    if (head==null)return true;
    //使用快慢节点寻找链表的中点，若是奇数的链表，slow在中间；若是偶数，slow在前半最后一个节点
    ListNode slow=head,fast=head.next;
    while (fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    fast=head;

    ListNode newhead=slow.next;
    slow.next=null;
    newhead=reverseListNode(newhead);
    ListNode newcur=newhead;
    while (newcur!=null){
        if (newcur.val!=fast.val)return false;
        newcur=newcur.next;
        fast=fast.next;
    }
    return true;
}

private ListNode reverseListNode(ListNode head){
    ListNode cur=head;
    ListNode before=null,next=null;
    while (cur!=null){
        next=cur.next;
        cur.next=before;
        before=cur;
        cur=next;
    }
    return before;
}
}

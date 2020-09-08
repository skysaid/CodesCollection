package Algorithm;

import java.util.*;

public class a146 {


    public static void main(String[] args) {
        LRUCache l=new LRUCache(2);
        //1
//        System.out.println(l.get(2));
//        l.put(2,6);
//        System.out.println(l.get(1));
//        l.put(1,5);
//        l.put(1,2);
//        System.out.println(l.get(1));
//        System.out.println(l.get(2));
        l.put(1,1);
        System.out.println("null");
        l.put(2,2);
        System.out.println("null");
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println("null");
        System.out.println(l.get(2));
        l.put(4,4);
        System.out.println("null");
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }
}

class LRUCache {
    class Node {
        Node before;
        Node next;
        int key;
        int value;
        public Node(){}
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    HashMap<Integer,Node> elements;
    Node head,tail;
    int capacity;
    public LRUCache(int capacity) {
        this.elements=new HashMap<>();
        this.head=new Node();
        this.tail=new Node();
        head.next=tail;
        tail.before=head;
        this.capacity=capacity;
    }

    public int get(int key) {
        if (!elements.containsKey(key))return -1;
        Node cur=elements.get(key);
        moveToHead(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        Node cur=elements.get(key);
        if (cur!=null){
            cur.value=value;
        }else {
            cur=new Node(key,value);
            elements.put(key,cur);
        }
        moveToHead(cur);
        while (elements.size()>capacity){
            elements.remove(tail.before.key);
            removeLast();
        }
    }

    private void removeLast(){
        Node temp=tail.before;
        temp.before.next=tail;
        tail.before=temp.before;
        temp.next=null;
    }
    private void moveToHead(Node node){
        if (node.before!=null){
            node.next.before=node.before;
            node.before.next=node.next;
        }
        node.next=head.next;
        head.next.before=node;
        head.next=node;
        node.before=head;
    }
}
//超时
//class LRUCache {
//    //用优先队列来排序
//    PriorityQueue<Integer> queue;
//    HashMap<Integer, Integer> elements;
//    LinkedList<Integer> count;
//    int capacity;
//
//    public LRUCache(int capacity) {
//        this.queue = new PriorityQueue<>();
//        this.elements = new HashMap<>();
//        this.capacity = capacity;
//        this.count=new LinkedList<Integer>();
//    }
//
//    public int get(int key) {
//        if (elements.isEmpty())return -1;
//        if (!elements.containsKey(key))return -1;
//        int i=0;
//        for (;i<count.size();i++){
//            if (count.get(i)==key)break;
//        }
////        if (i==count.size())return -1;
//        count.remove(i);
//        count.addFirst(key);
//        return elements.get(key);
//    }
//
//    public void put(int key, int value) {
//        boolean notin=true;
//        if (elements.containsKey(key))notin=false;
//        elements.put(key,value);
//        count.remove(Integer.valueOf(key));
//        count.addFirst(key);
//        while (count.size()>this.capacity){
//            if (notin)elements.remove(count.getLast());
//            count.removeLast();
//        }
//    }
//}
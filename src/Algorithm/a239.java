package Algorithm;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class a239 {
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> queue =new PriorityQueue<>((a,b)->nums[b]-nums[a]);
//        for (int i=0;i<k;i++)queue.add(i);
//        int[] res=new int[nums.length+1-k];
//        res[0]=nums[queue.peek()];
//        int i=0;
//        int cur=k;
//        while (cur<nums.length){
//            while (!queue.isEmpty()&&queue.peek()<cur-k+1)queue.poll();
//            queue.add(cur);
//            cur++;
//            res[++i]=nums[queue.peek()];
//        }
//        return res;
//    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list=new LinkedList<>();
        for (int i=0;i<k;i++){
            while (!list.isEmpty()&&nums[i]>nums[list.getLast()]){
                list.removeLast();
            }
            list.addLast(i);
        }
        int[] res= new int[nums.length-k+1];
        res[0]=nums[list.getFirst()];
        int index=1;
        int i=k;
        while (i<nums.length){
            while (!list.isEmpty()&&list.getFirst()<i-k+1)list.removeFirst();
            while (!list.isEmpty()&&nums[i]>nums[list.getLast()]){
                list.removeLast();
            }
            list.addLast(i);
            res[index++]=nums[list.getFirst()];
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums={1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
}

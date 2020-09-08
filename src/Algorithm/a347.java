package Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class a347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>((n1,n2)->{return map.get(n2)-map.get(n1);});
        for (int n:map.keySet()){
            queue.add(n);
        }
        int[] res=new int[k];
        for (int i=0;i<k;i++){
            res[i]=queue.poll();
        }
        return res;
    }
}

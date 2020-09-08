package Algorithm;

import java.util.HashMap;

public class a560 {
    public int subarraySum(int[] nums, int k) {
        int pre=0,res=0;
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>(){{put(0,1);}};
        for (int i=0;i<nums.length;i++){
            pre+=nums[i];
            if (map.containsKey(pre-k))res+=map.get(pre-k);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return res;
    }
}

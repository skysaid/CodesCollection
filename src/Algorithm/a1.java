package Algorithm;

import java.util.HashMap;

//两数和
public class a1 {
    public int[] twoSum(int[] nums, int target) {
        //以target-num为键记录num索引
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(target-nums[i],i);
            }else {
                return new int[]{i,map.get(nums[i])};
            }
        }
        return new int[2];
    }
}

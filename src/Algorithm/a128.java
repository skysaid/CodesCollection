package Algorithm;

import java.util.Arrays;
import java.util.HashSet;

public class a128 {
    public int longestConsecutive(int[] nums) {
        if (nums==null||nums.length==0)return 0;
        HashSet<Integer> set=new HashSet<Integer>();
        for (int i=0;i<nums.length;i++)set.add(nums[i]);
        int res=1;
        for (int i=0;i<nums.length;i++){
            int temp=nums[i];
            int nowlen=1;
            if (set.contains(temp-1))continue;
            while (set.contains(temp+1)){
                temp++;
                nowlen++;
                res=Math.max(res,nowlen);
            }
        }
        return res;
    }
}

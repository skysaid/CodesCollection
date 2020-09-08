package Algorithm;

import java.util.Arrays;

public class a169 {
//    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。


    public int majorityElement(int[] nums) {
//        int[] copy=nums.clone();
//        Arrays.sort(copy);
//        return copy[copy.length/2];
        int cur=0;
        int count=0;
        for (int num:nums){
            if (count==0){
                cur=num;
            }
            count=(cur==num)?count+1:count-1;
        }
        return cur;
    }
}

package Algorithm;

import java.util.Arrays;

public class a31 {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1)return;
        int len=nums.length;
        int index=len-1;
        while (index>=1&&nums[index-1]>=nums[index])index--;

        if (index==0&&nums[index]>=nums[index+1]){
            Arrays.sort(nums);
            return;
        }
        while (index>=1&&nums[index-1]>nums[len-1])len--;
        int temp=nums[index-1];
        nums[index-1]=nums[len-1];
        nums[len-1]=temp;
        Arrays.sort(nums,index,nums.length);
    }

    public static void main(String[] args) {
        int[] nums={2,3,1};
        new a31().nextPermutation(nums);
    }
}

package SORT;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] nums){
        if (nums==null||nums.length<2)return;
        for (int i=0;i<nums.length;i++){
            int minIndex=i;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]<nums[minIndex])minIndex=j;
            }
            if (minIndex!=i)swap(nums,minIndex,i);
        }
    }
    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    public static void main(String[] args){
        int[] nums={5,7,7,4,5,3,9,11,10,1,3,2,2,1,14,16,16,15};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

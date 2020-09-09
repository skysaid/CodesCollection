package SORT;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] nums){
        for (int gap=nums.length/2;gap>0;gap=gap>>1){
            for (int i=gap;i<nums.length;i++){
                int j=i;
                while (j-gap>=0&&nums[j-gap]>nums[j]){
                    swap(nums,j-gap,j);
                    j-=gap;
                }
            }
        }
    }
    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    public static void main(String[] args){
        int[] nums={5,7,7,4,5,3,9,11,10,1,3,2,2,1,14,16,16,15};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

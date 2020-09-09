package SORT;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] nums,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        int l=left,r=mid+1;
        int k=0;
        while (l<=mid&&r<=right){
            if (nums[l]>nums[r]){
                temp[k++]=nums[r++];
            }else {
                temp[k++]=nums[l++];
            }
        }
        while (l<=mid)temp[k++]=nums[l++];
        while (r<=right)temp[k++]=nums[r++];
        System.arraycopy(temp,0,nums,left,k);
    }
    public static void mergeSort(int[] nums,int left,int right){
        if (left<right){
            int mid=(right-left)/2+left;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    public static void mergeSort(int[] nums){
        if (nums==null||nums.length<2)return;
        mergeSort(nums,0,nums.length-1);
    }
    public static void main(String[] args){
        int[] nums={5,7,7,4,5,3,9,11,10};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

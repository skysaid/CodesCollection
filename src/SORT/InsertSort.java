package SORT;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] nums){
        for (int i=1;i<nums.length;i++){
            int temp=nums[i];
            int j=i-1;
            while (j>=0&&nums[j]>temp){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=temp;
        }
    }
    public static void main(String[] args){
        int[] nums={3,5,2,1,2,6,7,7,9,8,10};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

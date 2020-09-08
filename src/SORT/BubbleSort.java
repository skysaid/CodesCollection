package SORT;

public class BubbleSort {
    public static void bubbleSort(int[] nums){
        if (nums==null||nums.length==0)return;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-i-1;j++){
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }

    }
    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,4,5,6,7,8,9,2,1,10};
        BubbleSort.bubbleSort(nums);
        for (int num: nums
        ) {
            System.out.print(num+" ");
        }
    }
}

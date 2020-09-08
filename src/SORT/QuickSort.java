package SORT;

public class QuickSort {
    public void quickSort(int[] nums,int low,int high){
        if (low>=high)return;
        int left=low;
        int right=high;
        int compareVal=nums[low];
        while (low<high){
            while (nums[high]>=compareVal&&low<high){
                high--;
            }
            while (nums[low]<=compareVal&&low<high){
                low++;
            }
            if (low<high){
                swap(nums,low,high);
            }
        }
        swap(nums,low,left);
        quickSort(nums,left,low-1);
        quickSort(nums,low+1,right);
    }
    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{3,4,5,6,7,8,9,2,1,10};
        new QuickSort().quickSort(nums,0,nums.length-1);
        for (int num: nums
             ) {
            System.out.print(num+" ");
        }
    }
}

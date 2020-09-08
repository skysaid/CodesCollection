package SORT;

public class HeapSort {
//    大顶堆
//    public static void heapSort(int[] nums){
//        for (int i=(nums.length-1)/2;i>=0;i--){
//            adjustHeap(nums,i,nums.length);
//        }
//
//        for (int i=nums.length-1;i>0;i--){
//            int temp=nums[i];
//            nums[i]=nums[0];
//            nums[0]=temp;
//            adjustHeap(nums,0,i);
//        }
//    }
//    public static void adjustHeap(int[] nums,int parent,int len){
//        int temp=nums[parent];
//        int left=2*parent+1;
//        while (left<len){
//            int right=left+1;
//            if (right<len&&nums[right]>nums[left]){
//                left++;
//            }
//            if (temp>=nums[left])break;
//            nums[parent]=nums[left];
//            parent=left;
//            left=2*left+1;
//        }
//        nums[parent]=temp;
//    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,4,5,6,7,8,9,2,1,10};
        HeapSort.heapSort(nums);
        for (int num: nums
        ) {
            System.out.print(num+" ");
        }
    }
    public static void heapSort(int[] nums){
        int len=nums.length;
        for (int i=(len-1)/2;i>=0;i--){
            adjustHeap(nums,i,len);
        }
        for (int i=len-1;i>0;i--){
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            adjustHeap(nums,0,i);
        }
    }
    public static void adjustHeap(int[] nums,int parent,int len){
        int temp=nums[parent];
        int left=parent*2+1;
        while (left<len){
            int right=left+1;
            if (right<len&&nums[right]>nums[left]){
                left++;
            }
            if (temp>=nums[left])break;
            nums[parent]=nums[left];
            parent=left;
            left=parent*2+1;
        }
        nums[parent]=temp;
    }
}

package 腾讯笔试;

public class 数组中的逆序对 {
    static int count=0;
    public static void merge(int[] nums,int left,int mid,int right,int[] temp){
        int k=0,i=left,j=mid+1;
        while (i<=mid&&j<=right){
            if (nums[i]>nums[j]){
                count+=mid-i+1;
                temp[k++]=nums[j++];
            }else {
                temp[k++]=nums[i++];
            }
        }
        while(i<=mid)temp[k++]=temp[i++];
        while (j<=right)temp[k++]=temp[j++];
        for (i=0;i<k;i++){
            nums[left+i]=temp[i];
        }
    }
    public static void mergeSort(int[] nums,int left,int right,int[] temp){
        if (left<right){
            int mid=(right-left)/2+left;
            mergeSort(nums,left,mid,temp);
            mergeSort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }


}

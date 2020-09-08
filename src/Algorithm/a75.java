package Algorithm;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

public class a75 {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int right=n-1;
        int left=0;
        int cur=0;
        while (cur<right){
            if (nums[cur]==0){
                swap(nums,left++,cur++);
            }else if (nums[cur]==2){
                swap(nums,right--,cur);
            }else {
                cur++;
            }
        }
    }
    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}

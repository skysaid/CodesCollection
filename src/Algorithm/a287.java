package Algorithm;
//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

public class a287 {
//    public int findDuplicate(int[] nums) {
//        int n=nums.length;
//        int ans=0;
//        for (int num:nums){
//            int i=Math.abs(num);
//            if (nums[i-1]>0)nums[i-1]*=-1;
//            else {
//                ans=i;
//            }
//        }
//        for (int num:nums){
//            int i=Math.abs(num);
//            if (nums[i-1]<0)nums[i-1]*=-1;
//        }
//        return ans;
//    }
    public int findDuplicate(int[] nums){
        int n =nums.length;
        int left =1, right=n-1;
        int count;
        if (n==2)return 1;
        while(left<right){
            count=0;
            int mid=(right+left)/2;
            for (int num:nums){
                if (num<=mid){
                    count++;
                }
            }
            if (count<=mid){
                left=mid;
            }else {
                right=mid-1;
            }
        }
        return left+1;
    }
}

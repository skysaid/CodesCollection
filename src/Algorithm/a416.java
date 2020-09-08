package Algorithm;

import java.util.Arrays;

public class a416 {
//    超时
//    public boolean canPartition(int[] nums) {
//        return trypartition(nums,0,0,0);
//    }
//    private boolean trypartition(int[] nums,int index,int a,int b){
//        if (index>=nums.length)return a==b;
//        boolean left=trypartition(nums,index+1,a+nums[index],b);
//        boolean right=trypartition(nums,index+1,a,b+nums[index]);
//        return left||right;
//    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num:nums)sum+=num;
        if (sum%2==1)return false;
        int target=sum/2;
        boolean[][] dp=new boolean[nums.length][target+1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<target+1;j++){
                dp[i][j]=dp[i-1][j];
                if (nums[i]==j)continue;
                if (nums[i]<j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }
            }
            if (dp[i][target])return true;
        }
        return dp[nums.length-1][target];
    }
}

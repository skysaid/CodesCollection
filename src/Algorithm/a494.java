package Algorithm;

public class a494 {
//    private int res=0;
//    public int findTargetSumWays(int[] nums, int S) {
//        dfs(nums,S,0);
//        return res;
//    }
//    private void dfs(int[] nums,int S,int index){
//        if (index==nums.length){
//            if (S==0){
//                res++;
//                return ;
//            }
//        }
//        dfs(nums,S-nums[index],index+1);
//        dfs(nums,S+nums[index],index+1);
//    }


//    把所有符号为正的数总和设为一个背包的容量，容量为x；把所有符号为负的数总和设为一个背包的容量，容量为y。
//    在给定的数组中，有多少种选择方法让背包装满。令sum为数组的总和，则x+y = sum。而两个背包的差为S,则x-y=S。从而求得x=(S+sum)/2。
//    基于上述分析，题目转换为背包问题：给定一个数组和一个容量为x的背包，求有多少种方式让背包装满。


//    public int findTargetSumWays(int[] nums, int S) {
//        int sum=0;
//        for (int num:nums){
//            sum+=num;
//        }
//        if (((S+sum)%2)==1)return 0;
//        if (sum<S)return 0;
//        int x=(S+sum)/2;
//        int[][] dp=new int[nums.length][x+1];
//        if (nums[0]<=x)dp[0][nums[0]]=1;
//        dp[0][0]+=1;
//        for (int i=1;i<nums.length;i++){
//            int j=x;
//            for (;j>=nums[i];j--){
//                dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
//            }
//            for (;j>=0;j--){
//                dp[i][j]=dp[i-1][j];
//            }
//        }
//
//        return dp[nums.length-1][x];
//    }
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (((S+sum)%2)==1)return 0;
        if (sum<S)return 0;
        int x=(S+sum)/2;
        int[] dp=new int[x+1];
        if (nums[0]<=x)dp[nums[0]]=1;
        dp[0]+=1;
        for (int i=1;i<nums.length;i++){
            int j=x;
            for (;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }

        }

        return dp[x];
    }
}

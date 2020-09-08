package Algorithm;
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

public class a198 {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==0)return 0;
//        int[] max_rob=new int[n];
//        max_rob[0] = nums[0];
        int first=nums[0];
        if (n==1)return nums[0];
//        max_rob[1] = nums[1]>nums[0]?nums[1]:nums[0];
        int second = nums[1]>nums[0]?nums[1]:nums[0];
        int cur;
        for (int i = 2;i<n;i++){
//            int max_rob[i]=Math.max(max_rob[i-1],max_rob[i-2]+nums[i]);
            cur=Math.max(second,first+nums[i]);
            first=second;
            second=cur;
        }
//        return max_rob[n-1];
        return second;
    }
}

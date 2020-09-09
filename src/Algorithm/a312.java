package Algorithm;

import java.util.Arrays;

public class a312 {
    public int[][] dp;
    public int maxCoins(int[] nums) {
        int[] a=new int[nums.length+2];
        a[0]=1;
        a[a.length-1]=1;
        dp=new int[a.length][a.length];
        for (int i=0;i<a.length;i++) Arrays.fill(dp[i],-1);
        for (int i=0;i<nums.length;i++){
            a[i+1]=nums[i];
        }
        return dfs(a,0,a.length-1);
    }
    public int dfs(int[] a,int i,int j){
        if (dp[i][j]!=-1)return dp[i][j];
        int max=0;
        for (int k=i+1;k<j;k++){
            max=Math.max(max,dfs(a,i,k)+a[i]*a[j]*a[k]+dfs(a,k,j));
        }
        dp[i][j]=max;
        return max;
    }
}

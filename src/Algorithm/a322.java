package Algorithm;

import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Map;

public class a322 {
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        dfs(coins,amount,coins.length-1,0);
//        return res==Integer.MAX_VALUE?0:res;
//    }
//    private int res=Integer.MAX_VALUE;
//    private void dfs(int[] coins, int amount, int index, int count){
//        if (amount==0){
//            res=Math.min(res,count);
//        }
//        if (amount<0)return;
//        if (index<0)return;
//        for (int i=amount/coins[index];i>=0 && count+i<res;i--){
//            dfs(coins,amount-i*coins[index],index-1,count+i);
//        }
//    }

//    public int coinChange(int[] coins, int amount) {
//        if (amount<1)return -1;
//        return rdfs(coins,amount,new int[amount]);
//    }
//    private int rdfs(int[] coins,int amount,int[] dp){
//        if (amount<0)return -1;
//        if (amount==0)return 0;
//        if (dp[amount-1]!=0)return dp[amount-1];
//        int min=Integer.MAX_VALUE;
//        for (int coin:coins){
//            int res=rdfs(coins,amount-coin,dp);
//            if (res>=0){
//                min=Math.min(res,min);
//            }
//        }
//        dp[amount-1]=(min==Integer.MAX_VALUE)?-1:min;
//        return dp[amount-1];
//    }

    public int coinChange(int[] coins, int amount) {
        if (amount<1)return -1;
        Arrays.sort(coins);
        int[] dp=new int[amount+1];
        dp[0]=0;
        for (int target=1;target<=amount;target++){
            int min=amount+1;
            for (int i=0;i<coins.length&&target>coins[i];i++){
                min=Math.min(min,dp[target-coins[i]]+1);
            }
            dp[target]=min;
        }
        return dp[amount]>amount?-1:dp[amount];
    }

}

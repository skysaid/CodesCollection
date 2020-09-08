package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
public class a279 {

    public int numSquares(int n) {
        int squareLimit=(int)Math.sqrt(n)+1;
        int[] square=new int[squareLimit+1];
        for (int i=1;i<squareLimit;i++){
            square[i]=i*i;
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<squareLimit&&i>=square[j];j++){
                dp[i]=Math.min(dp[i],dp[i-square[j]]+1);
            }
        }
        return dp[n];
    }
}

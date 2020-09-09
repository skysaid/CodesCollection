package Algorithm;

import java.util.Arrays;

public class a72 {
//    递归
//    public static int[][] dp;
//    public static int minDistance(String word1, String word2) {
//        dp=new int[word1.length()][word2.length()];
//        for (int i=0;i<word1.length();i++) Arrays.fill(dp[i],-1);
//        return dfs(word1,word1.length()-1,word2,word2.length()-1);
//    }
//    public static int dfs(String word1,int i,String word2,int j){
//        if (i==-1||j==-1){
//            return 1+Math.max(i,j);
//        }
//        if (dp[i][j]!=-1)return dp[i][j];
//        if (word1.charAt(i)==word2.charAt(j)){
//            return dfs(word1,i-1,word2,j-1);
//        }
//        int insert=dfs(word1,i,word2,j-1);
//        int change=dfs(word1,i-1,word2,j-1);
//        int delete=dfs(word1,i-1,word2,j);
//        dp[i][j]=1+Math.min(Math.min(insert,change),delete);
//        return dp[i][j];
//    }
    public int minDistance(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        if (word1.equals(word2))return 0;
        if (len1==0||len2==0)return Math.max(len1,len2);
        int[][] dp=new int[len1+1][len2+1];
        for (int j=0;j<=len2;j++)dp[0][j]=j;
        for (int i=0;i<=len1;i++)dp[i][0]=i;
        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1))dp[i][j]=dp[i-1][j-1];
                else {
                    int insert=dp[i][j-1];
                    int change=dp[i-1][j-1];
                    int delete=dp[i-1][j];
                    dp[i][j]=1+Math.min(insert,Math.min(change,delete));
                }
            }
        }
        return dp[len1][len2];
    }
}

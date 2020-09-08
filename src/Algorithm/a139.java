package Algorithm;

import java.util.HashSet;
import java.util.List;

public class a139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for (int i=0;i<=len;i++){
            for (int j=0;j<i;j++){
                if (dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}

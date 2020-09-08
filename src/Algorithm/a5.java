package Algorithm;

public class a5 {
//    动态规划
//    public static String longestPalindrome(String s) {
//        if (s.length()<2)return s;
//        int len = s.length();
//        boolean[][] dp=new boolean[len][len];
//        for (int i=0;i<len;i++){
//            dp[i][i]=true;
//        }
//        int max=0;
//        int begin=0;
//        for (int j=1;j<len;j++){
//            for (int i=0;i<j;i++){
//                if (s.charAt(i)!=s.charAt(j)){
//                    dp[i][j]=false;
//                }else {
//                    if (j-i-1<2)dp[i][j]=true;
//                    else {
//                        dp[i][j]=dp[i+1][j-1];
//                    }
//                }
//                if (dp[i][j]&&j-i+1>max){
//                    max=j-i+1;
//                    begin=i;
//                }
//            }
//        }
//        return s.substring(begin,begin+max);
//    }


    public static String longestPalindrome(String s){
        if (s==null)return "";
        int len=s.length();
        if (len<2)return s;
        int maxlen=0;
        int begin=1;
        for (int i=0;i<s.length();i++){
            int len1=helper(s,i,i);
            int len2=helper(s,i,i+1);
            int temp=Math.max(len1,len2);
            if (temp>maxlen){
                maxlen=temp;
                begin=i-(temp-1)/2;
            }
        }
        return s.substring(begin,begin+maxlen);
    }
    private static int helper(String s, int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String s="xxabccbadd";
        System.out.println(longestPalindrome(s));
    }
}

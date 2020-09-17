package Algorithm;

import java.util.ArrayList;

public class a32 {
//    public static int longestValidParentheses(String s) {
//        int max=0;
//        StringBuilder temp=new StringBuilder();
//        int count=0;
//        for (int i=0;i<s.length();i++){
//            if (s.charAt(i)==')'){
//                count--;
//            }else {
//                count++;
//            }
//            if (count<0){
//                temp=new StringBuilder();
//                count=0;
//            }else{
//                temp.append(s.charAt(i));
//                if (count==0&&temp.length()>max){
//                    max=temp.length();
//                }
//            }
//        }
//        count=0;
//        temp=new StringBuilder();
//        for (int i=s.length()-1;i>=0;i--){
//            if (s.charAt(i)=='('){
//                count--;
//            }else {
//                count++;
//            }
//            if (count<0){
//                temp=new StringBuilder();
//                count=0;
//            }else{
//                temp.append(s.charAt(i));
//                if (count==0&&temp.length()>max){
//                    max=temp.length();
//                }
//            }
//        }
//        return max;
//    }
    public static int longestValidParentheses(String s) {
        int n=s.length();
        int[] dp=new int[n];
        int res=0;
        for (int i=1;i<s.length();i++){
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s="())";
        System.out.println(longestValidParentheses(s));
    }
}

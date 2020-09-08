package Algorithm;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class a22 {
//    public List<String> generateParenthesis(int n) {
//        List<String> ans =new ArrayList<>();
//        dfs(n,n,ans,"");
//        return ans;
//    }

//    /**
//     *
//     * @param left 剩下的左括号数量
//     * @param right 剩下的右括号数量
//     * @param ans
//     * @param cur
//     */
//    private void dfs(int left,int right, List<String> ans,String cur){
//        if (left==0&&right==00){
//            ans.add(cur);
//            return;
//        }
//        if (left>0){
//            dfs(left-1,right,ans,cur+"(");
//        }
//        if (right>left){
//            dfs(left,right-1,ans,cur+")");
//        }
//    }
public List<String> generateParenthesis(int n) {
    List<String> ans =new ArrayList<>();
    ArrayList<String>[] cache =new ArrayList[n+1];
    cache[0]=new ArrayList(){{add("");}};
    for (int i=1;i<=n;i++){
        ArrayList<String> cur =new ArrayList<>();
        for (int j=0;j<i;j++){
            ArrayList<String> left=cache[j];
            ArrayList<String> right=cache[i-1-j];
            for (String s1:left){
                for (String s2:right){
                    cur.add("("+s1+")"+s2);
                }
            }
        }
        cache[i]=cur;
    }
    return cache[n];
}


}

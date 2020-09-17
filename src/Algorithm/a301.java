package Algorithm;

import java.util.*;

public class a301 {
    public void dfs(String s,int index,int count,int leftToDelete,int rightToDelete,String temp,List<String> res){
        if (count<0)return;
        if (index==s.length()){
            if (count==0&&leftToDelete==0&&rightToDelete==0){
                if (res.isEmpty()){
                    res.add(temp);
                }else {
                    if (temp.length()>res.get(0).length()){
                        res.clear();
                        res.add(temp);
                        return;
                    }else if (temp.length()==res.get(0).length()){
                        res.add(temp);
                    }
                }
            }
            return ;
        }
        char c=s.charAt(index);
        if (c=='('){
            if (leftToDelete>0){
                dfs(s,index+1,count,leftToDelete-1,rightToDelete,temp,res);
            }
            dfs(s,index+1,count+1,leftToDelete,rightToDelete,temp+c,res);
        }else if (c==')'){
            if (rightToDelete>0){
                dfs(s,index+1,count,leftToDelete,rightToDelete-1,temp,res);

            }
            dfs(s,index+1,count-1,leftToDelete,rightToDelete,temp+c,res);
        }else {
            dfs(s,index+1,count,leftToDelete,rightToDelete,temp+c,res);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new LinkedList<>();
        int leftToDelete=0;
        int rightToDelete=0;
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='('){
                leftToDelete++;
            }else if (c==')'){
                if (leftToDelete>0){
                    leftToDelete--;
                }else {
                    rightToDelete++;
                }
            }
        }
        dfs(s,0,0,leftToDelete,rightToDelete,"",res);
        Set<String> set=new HashSet<>(res);
        res.clear();
        res.addAll(set);
        return res;
    }
    public static void main(String[] args){
        a301 test=new a301();
        System.out.println(test.removeInvalidParentheses("()"));
    }
}

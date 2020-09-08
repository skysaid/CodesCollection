package Algorithm;

import java.util.*;

public class a17 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)return Collections.emptyList();
        List<String> res=new ArrayList<>();
        helper(digits,0,"",res);
        return res;
    }
    public void helper(String digits, int index,String cur,List<String> res){
        if (index==digits.length()){
            res.add(cur);
            return;
        }
        String temp=phone.get(digits.substring(index,index+1));
        for (int j=0;j<temp.length();j++){
            helper(digits,index+1,cur+temp.substring(j,j+1),res);
        }
    }
}

package Algorithm;

import java.util.HashMap;

public class a3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)return 0;
        int left=0,right=0,res=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while (right<s.length()){
            char now=s.charAt(right);
            if (map.containsKey(now)) {
                int len=map.get(now)+1;
                while (left<len){
                    map.remove(s.charAt(left));
                    left++;
                }
            }
            res=Math.max(res,right-left+1);
            map.put(now,right);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str="pwwkew";
        System.out.println(new a3().lengthOfLongestSubstring(str));
    }

}

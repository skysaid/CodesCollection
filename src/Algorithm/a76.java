package Algorithm;

import java.util.HashMap;

public class a76 {
//    暴力解超时
//    public static String minWindow(String s, String t) {
//        HashMap<Character,Integer> map=new HashMap<>();
//        int len=t.length();
//        int min=s.length();
//        int minlen=s.length();
//        for (Character c:t.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        HashMap<Character,Integer> cur;
//        for (int i=0;i<s.length();i++){
//            cur=new HashMap<>(map);
//            int count=len;
//            int j=i;
//            while (j<s.length()&&count!=0){
//                char nowchar=s.charAt(j);
//                if (cur.getOrDefault(nowchar,0)>0){
//                    count--;
//                    cur.put(nowchar,cur.get(nowchar)-1);
//                }
//                j++;
//            }
//            if (count==0){
//                if (minlen>=j-i){
//                    minlen=j-i;
//                    min=i;
//                }
//            }
//        }
//        return min+minlen>s.length()?s.substring(min,s.length()):s.substring(min,min+minlen);
//    }
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        int tlen=t.length();
        int start=s.length();
        if (tlen>start)return "";
        int minlen=s.length();
        for (Character c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> cur=new HashMap<>(map);
        int left=0,right=0;
        int count=tlen;
        while (right<s.length()){
            while (right<s.length()&&count!=0){
                char now=s.charAt(right);
                if (map.containsKey(now)){
                    if (cur.get(now)>0){
                        count--;
                    }
                    cur.put(now,cur.get(now)-1);
                }
                right++;
            }
            while (count==0){
                if (minlen>=right-left){
                    minlen=right-left;
                    start=left;
                }
                char leftnow=s.charAt(left);
                if (map.containsKey(leftnow)&&map.get(leftnow)>cur.get(leftnow)){
                    cur.put(leftnow,cur.get(leftnow)+1);
                    if (cur.get(leftnow)>0){
                        count++;
                    }
                }
                left++;
            }
        }
        int end=start+minlen;
        return end>=s.length()?s.substring(start):s.substring(start,end);
    }
    public static void main(String[] args){
        String s="ABC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }
}

package Algorithm;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
import java.lang.reflect.Array;
import java.util.*;

public class a49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)return Collections.emptyList();
        Map<String, ArrayList<String>> map=new HashMap<>();
        for (String str:strs){
            String old=str;
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            StringBuffer sb=new StringBuffer();
            sb.append(chars);
            String now=sb.toString();

            if (!map.containsKey(now)){
                map.put(now,new ArrayList<>());
            }
            map.get(now).add(old);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String str="abc";
        System.out.println(str.toCharArray());
    }
}

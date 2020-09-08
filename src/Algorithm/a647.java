package Algorithm;
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
public class a647 {
    public int countSubstrings(String s) {
        int len=s.length();
        if (len==0)return 1;
        int res=0;
        for (int i=0;i<len;i++){
            for (int j=0;i+j<len&&i-j>=0&&s.charAt(i+j)==s.charAt(i-j);j++){
                res++;
            }
        }
        for (int i=0;i<len;i++){
            for (int j=0;i+j+1<len&&i-j>=0&&s.charAt(i+j+1)==s.charAt(i-j);j++){
                res++;
            }
        }
        return res;
    }
}

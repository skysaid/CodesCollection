package 笔试题;

import java.awt.datatransfer.StringSelection;

public class 翻转数字 {
    public static int reverse(int num){
        String s=num+"";
        String c="";
        if (s.charAt(0)=='-'){
            c="-";
            s=s.substring(1);
        }
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return Integer.parseInt(c+sb.toString());
    }
    public static void main(String[] args){
        System.out.println(reverse(-123));
        System.out.println(reverse(3334));
    }
}

package 笔试题;

import java.util.LinkedList;
import java.util.Scanner;

public class 压缩字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        scanner.close();
        System.out.println(decode(next));
    }

    public static String decode(String words){
        while (words.contains("]")){
            int right = words.indexOf("]");
            int left = words.lastIndexOf("[", right);
            String repeatStr = words.substring(left+1, right);
            String[] split = repeatStr.split("\\|");
            words = words.replace("["+repeatStr+"]",
                    String.join("", Collections.nCopies(Integer.parseInt(split[0]), split[1])));
        }
        return words;
    }

//    public static String decode(String str){
//        LinkedList<String> strStack=new LinkedList<>();
//        LinkedList<Integer> numStack=new LinkedList<>();
//        StringBuilder sb=new StringBuilder();
//        int count=0;
//        for (int i=0;i<str.length();i++){
//            char c=str.charAt(i);
//            if (c>='0'&&c<='9'){
//                count=10*count+(c-'0');
//            }else if (c=='['){
//                strStack.add(sb.toString());
//                sb=new StringBuilder();
//            }else if (c=='|'){
//                numStack.add(count);
//                count=0;
//            }else if (c==']'){
//                StringBuilder temp=new StringBuilder();
//                count=numStack.removeLast();
//                String now=sb.toString();
//                while (count!=0){
//                    temp.append(now);
//                    count--;
//                }
//                sb=new StringBuilder();
//                sb.append(strStack.removeLast());
//                sb.append(temp.toString());
//            }else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }

}

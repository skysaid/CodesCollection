package Algorithm;

import java.util.LinkedList;

public class a394 {
//    public String decodeString(String s) {
//        StringBuilder res = new StringBuilder();
//        int multi = 0;
//        LinkedList<Integer> stack_multi = new LinkedList<>();
//        LinkedList<String> stack_res = new LinkedList<>();
//        for(Character c : s.toCharArray()) {
//            if(c == '[') {
//                stack_multi.addLast(multi);
//                stack_res.addLast(res.toString());
//                multi = 0;
//                res = new StringBuilder();
//            }
//            else if(c == ']') {
//                StringBuilder tmp = new StringBuilder();
//                int cur_multi = stack_multi.removeLast();
//                for(int i = 0; i < cur_multi; i++) tmp.append(res);
//                res = new StringBuilder(stack_res.removeLast() + tmp);
//            }
//            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
//            else res.append(c);
//        }
//        return res.toString();
//    }
    public String decodeString(String s) {
        StringBuilder sb= new StringBuilder();
        LinkedList<String> str=new LinkedList<>();
        LinkedList<Integer> num=new LinkedList<>();
        int curnum=0;
        for (char c:s.toCharArray()){
            if (c=='['){
                str.add(sb.toString());
                num.add(curnum);
                sb=new StringBuilder();
                curnum=0;
            }else if (c==']'){
                StringBuilder temp=new StringBuilder();
                int times=num.pollLast();
                for (int i=0;i<times;i++){
                    temp.append(sb.toString());
                }
                sb=new StringBuilder(str.pollLast()+temp.toString());
            }else if (c>='0'&&c<='9'){
                curnum=curnum*10+Integer.parseInt(c+"");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}

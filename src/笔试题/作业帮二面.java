package 笔试题;

import java.util.*;

public class 作业帮二面 {
    public static List<Integer> maxSub(int[] nums){
        if(nums==null||nums.length==0)return Collections.emptyList();
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<Integer> temp;
        int max=0,sum;
        for (int i=0;i< nums.length;i++){
            temp=new ArrayList<>();
            sum=0;
            for (int j=i;j<nums.length;j++){
                sum+=nums[j];
                temp.add(nums[j]);
                if (sum>=max){
                    max=sum;
                    res=new ArrayList<>(new ArrayList<>(temp));
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] nums={1,-2,3,10,-4,7,2,-5};
        System.out.println(Arrays.toString(maxSub(nums).toArray()));
    }
}

//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Main {
//    public static double f(String log){
//        Pattern p= Pattern.compile("code=\\d\\d\\d");
//        Matcher m=p.matcher(log);
//        double need=0;
//        double max=0;
//        while (m.find()){
//            String[] temp=m.group().split("=");
//            if (temp[1].equals("200"))need++;
//            max++;
//        }
//        return need/max;
//    }
//    public static void main(String[] args) {
//        //Scanner in = new Scanner(System.in);
//        //int a = in.nextInt();
//        //System.out.println(a);
//        System.out.println("Hello World!");
//    }
//}
package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
//
//        注意：
//        总人数少于1100人。


public class a406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{return a[0]==b[0]?a[1]-b[1]:b[0]-a[0];});
        ArrayList<int[]> list=new ArrayList<>();
        for (int[] curPerson:people){
            list.add(curPerson[1],curPerson);
        }
        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        people=new a406().reconstructQueue(people);
//        System.out.println(people==null);
        for (int[] i:people){
            System.out.println(i[0]+":"+i[1]);
        }
    }
}

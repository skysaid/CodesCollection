package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class a56 {
    public int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length==0)return new int[0][0];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> list=new ArrayList<>();
        int i=1;
        int index=0;
        list.add(intervals[0]);
        while (i<intervals.length){
            if (list.get(index)[1]>=intervals[i][1]){
            }else if (list.get(index)[1]>=intervals[i][0]){
                list.get(index)[1]=intervals[i][1];
            }else if (list.get(index)[1]<intervals[i][0]){
                list.add(intervals[i]);
                index++;
            }
            i++;
        }
        int[][] res=new int[list.size()][2];
        list.toArray(res);
        return res;
    }
}

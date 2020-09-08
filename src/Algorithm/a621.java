package Algorithm;

import java.util.Arrays;

public class a621 {
    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        for (char c:tasks){
            map[c-'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25]>0){
            for (int i=0;i<n;i++){
                if (i-n>=0){
                    if (map[25]==0)break;
                    if (map[25-i]>0)map[25-i]--;
                }
                time++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}

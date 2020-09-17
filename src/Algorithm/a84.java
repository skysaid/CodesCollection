package Algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class a84 {
//        暴力解
//    public int largestRectangleArea(int[] heights) {
//        int max=0;
//        int len=0;
//        for (int i=0;i<heights.length;i++){
//            len=1;
//            int curindex=i;
//            int high=heights[i];
//            while (curindex>=0&&heights[curindex]>0){
//                high=Math.min(high,heights[curindex]);
//                max=Math.max(max,high*len);
//                len++;
//                curindex--;
//            }
//        }
//        return max;
//    }
//    单调栈
//    public static int largestRectangleArea(int[] heights) {
//        LinkedList<Integer> stack=new LinkedList<>();
//        int n=heights.length;
//        int max=0;
//        int left[]=new int[n];
//        int right[]=new int[n];
//        Arrays.fill(right,n);
//        for (int i=0;i<n;i++){
//            while (!stack.isEmpty()&&heights[stack.getLast()]>heights[i]){
//                int cur=stack.removeLast();
//                right[cur]=i;
//            }
//            if (!stack.isEmpty()){
//                left[i]=stack.getLast();
//            }else {
//                left[i]=-1;
//            }
//            stack.addLast(i);
//        }
//        for (int i=0;i<n;i++){
//            max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
//        }
//        return max;
//    }

    public static int largestRectangleArea(int[] heights) {
        int len=heights.length;
        int max=0;
        Deque<Integer> stack=new ArrayDeque<>(len+2);
        int[] newh =new int[len+2];
        for (int i=1;i<=len;i++)newh[i]=heights[i-1];
        stack.addLast(0);
        for (int i=1;i<len+2;i++){
            while (newh[stack.getLast()]>newh[i]){
                int hight=newh[stack.removeLast()];
                int width=i-stack.getLast()-1;
                max=Math.max(max,width*hight);
            }
            stack.addLast(i);
        }
        return max;
    }

    public static void main(String[] args){
        int[] heights={1,2,3,4,5};
        System.out.println(largestRectangleArea(heights));
    }
}

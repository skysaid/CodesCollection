package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
public class a739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack =new Stack<>();
        int[] res= new int[T.length];
        for (int i=0;i<T.length;i++){
            if (stack.isEmpty()){
                stack.add(i);
                continue;
            }
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int out=stack.pop();
                res[out]=i-out;
            }
            stack.add(i);
        }
        return res;
    }
}

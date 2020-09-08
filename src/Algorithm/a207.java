package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class a207 {
//    int[][] map;
////    //递归使用的栈
////    Stack<Integer> stack;
////    //用来标记是否搜索过
////    int[] visited;
////    //判断是否有环
////    boolean valid=true;
//////    答案
////    int[] res;
////
////    public int[] findOrder(int numCourses, int[][] prerequisites) {
//////        if(prerequisites.length==1)return new int[]{prerequisites[0][1],prerequisites[0][0]};
////        stack=new Stack<>();
////        map=new int[numCourses][numCourses];
////        for (int[] a:map){
////            Arrays.fill(a,numCourses);
////        }
////        for (int[] a:prerequisites){
////            map[a[0]][a[1]]=1;
////        }
////        visited=new int[numCourses];
////        res=new int[numCourses];
////        for (int i=0;i<numCourses&&valid;i++){
////            if (visited[i]==0){
////                dfs(i);
////            }
////            if (!valid)return new int[0];
////        }
////        for (int i=numCourses-1;i>=0;i--){
////            res[i]=stack.pop();
////        }
////        return res;
////    }
////    public void dfs(int i){
////        int n=map.length;
////        visited[i]=1;
////        for (int j=0;j<n;j++){
////            if (i==j)continue;
////            if (map[i][j]==n)continue;
////            if (visited[j]==1){
////                valid=false;
////            }
////            if (visited[j]==0){
////                dfs(j);
////            }
////            if (!valid)return;
////        }
////        stack.add(i);
////        visited[i]=2;
////    }
ArrayList<ArrayList<Integer>> map;
    int[] visited;
    boolean res=true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map=new ArrayList<>();
        visited=new int[numCourses];

        for(int[] temp: prerequisites){
            map.get(temp[0]).add(temp[1]);
        }
        for(int i=0;i<numCourses&&res;i++){
            if(visited[i]==0)dfs(i);
        }
        return res;
    }
    public void dfs(int i){
        visited[i]=1;
        ArrayList<Integer> temp= map.get(i);
        for(int to:temp){
            if(visited[to]==1){
                res=false;
                return;
            }
            if(visited[to]==0){
                dfs(to);
            }
        }
        visited[i]=2;
    }
}

package shopee;

import java.util.ArrayList;
import java.util.Scanner;

public class a2 {
    public static void dfs(int[] nums, int m,int index, ArrayList<Integer> inlist,ArrayList<ArrayList<Integer>> ans){
        if (m==0){
            ans.add(new ArrayList<>(inlist));
        }
        if (index>=nums.length)return;
        for (int i=index;i<nums.length;i++){
            if (m-nums[i]>=0){
                inlist.add(nums[i]);
                dfs(nums,m-nums[i],i+1,inlist,ans);
                inlist.remove(inlist.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n=in.nextInt();
            int m=in.nextInt();
            int[] nums=new int[n];
            for (int i=0;i<n;i++){
                nums[i]=i+1;
            }
            ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
            dfs(nums,m,0,new ArrayList<>(),ans);
            StringBuilder sb;
            for (ArrayList<Integer> inlist:ans){
                sb=new StringBuilder();
                for (Integer i:inlist){
                    sb.append(i);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb.toString());
            }
        }
    }
}

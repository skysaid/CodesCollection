package Algorithm;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的数字可以无限制重复被选取。
//        说明：
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。 

import java.lang.reflect.Array;
import java.util.*;

public class a39 {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans=new ArrayList<>();
//        dfs(candidates,0,target,ans,new ArrayList<>());
//        return ans;
//    }
//    private void dfs(int[] candidates,int index,int target,List<List<Integer>> ans,ArrayList<Integer> nowans){
//        if (target==0){
//            ans.add(new ArrayList<>(nowans));
//            return;
//        }
//        for (int i=index;i<candidates.length;i++){
//            if (target<candidates[i])continue;
//            nowans.add(candidates[i]);
//            dfs(candidates,i,target-candidates[i],ans,nowans);
//            nowans.remove(nowans.size()-1);
//        }
//    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        Map<Integer,List<List<Integer>>> dp =new HashMap<>();
        dfs(candidates,0,target,ans,new ArrayList<>(),dp);
        return dp.get(target)==null?Collections.emptyList():dp.get(target);
    }
    private void dfs(int[] candidates,int index,int target,List<List<Integer>> ans,ArrayList<Integer> nowans,Map<Integer,List<List<Integer>>> dp){
        if (dp.containsKey(target)){
            List<List<Integer>> temp=dp.get(target);
            int sum=0;
            for (List<Integer> list:temp){
                list.add(candidates[index]);
                if (sum==0){
                    for (int i:list){
                        sum+=i;
                    }
                }
            }
            dp.put(sum,temp);
            return;
        }
        if (target==0){
            ans.add(new ArrayList<>(nowans));
            int sum=0;
            for (int i:nowans){
                sum+=i;
            }
            dp.put(sum,new ArrayList<>(ans));
            return;
        }
        for (int i=index;i<candidates.length;i++){
            if (target<candidates[i])continue;
            nowans.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],ans,nowans,dp);
            nowans.remove(nowans.size()-1);
        }
    }
}

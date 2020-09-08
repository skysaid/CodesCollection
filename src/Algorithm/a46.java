package Algorithm;

import java.util.ArrayList;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
public class a46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(nums,new boolean[nums.length],0,new ArrayList<>(),ans);
        return ans;
    }

    private void dfs(int[] nums, boolean[] used, int index, List<Integer> cur, List<List<Integer>> ans){
        if (cur.size()==nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (!used[i]){
            cur.add(nums[i]);
            used[i]=true;
            dfs(nums,used,index+1,cur,ans);
            used[i]=false;
            cur.remove(cur.size()-1);
            }
        }
    }
}

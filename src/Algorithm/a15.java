package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a15 {
//        递归超时
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        dfs(nums,0,0,new ArrayList<>(),res);
        return res;
    }
    public void dfs(int[] nums, int index,int left, List<Integer> temp, List<List<Integer>> res){
        if (temp.size()==3){
            if (left==0)res.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(nums,i+1,left+nums[i],temp,res);
            while (i+1<nums.length&&nums[i+1]==nums[i])i++;
            temp.remove(temp.size()-1);
        }
    }
}

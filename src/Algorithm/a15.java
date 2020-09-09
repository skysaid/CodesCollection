package Algorithm;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a15 {
//        递归超时
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> res=new ArrayList<>();
//        dfs(nums,0,0,new ArrayList<>(),res);
//        return res;
//    }
//    public void dfs(int[] nums, int index,int left, List<Integer> temp, List<List<Integer>> res){
//        if (temp.size()==3){
//            if (left==0)res.add(new ArrayList<Integer>(temp));
//            return;
//        }
//
//        for (int i=index;i<nums.length;i++){
//            temp.add(nums[i]);
//            dfs(nums,i+1,left+nums[i],temp,res);
//            while (i+1<nums.length&&nums[i+1]==nums[i])i++;
//            temp.remove(temp.size()-1);
//        }
//    }
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums==null&&nums.length<3)return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (int i=0;i<=nums.length-3;i++){
            if (nums[i]>0)break;
            if (i>0&&nums[i]==nums[i-1])continue;
            int j=i+1,k=nums.length-1;
            int target=-nums[i];
            for (j=i+1;j<=nums.length-2;j++){
                if (j>i+1&&nums[j]==nums[j-1])continue;
                while (j<k&&nums[j]+nums[k]>target)k--;
                if (j==k)break;
                if (nums[j]+nums[k]==target){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums= {0,0,0,0,0};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
    }
}

package Algorithm;

import java.util.ArrayList;
import java.util.List;
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。说明：解集不能包含重复的子集。
public class a78 {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans =new ArrayList<>();
//        ans.add(new ArrayList<>());
//        helper(nums,0,new ArrayList<>(), ans);
//        return ans;
//    }
//    private void helper(int[] nums,int index, List<Integer> inlist,List<List<Integer>> ans ){
//        if (index>=nums.length)return;
//        for (int i=index;i<nums.length;i++){
//            inlist.add(nums[i]);
//            ans.add(new ArrayList<>(inlist));
//            helper(nums,i+1,inlist,ans);
//            inlist.remove(inlist.size()-1);
//        }
//        return;
//    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        int n=nums.length;
        int maxmask=1<<n;
        for (int i = 0; i < maxmask;i++){
            List<Integer> inlist=new ArrayList<>();
            for (int j=0;j<n;j++){
                if (((i>>j)&1)==1)inlist.add(nums[j]);
            }
            ans.add(inlist);
        }
        return ans;

    }

    public static void main(String[] args) {
//        int n=8;
//        int maxmask=1<<n;
//        for (int i = 0; i < (int) Math.pow(2,n);i++){
//            System.out.println(Integer.toBinaryString(i|maxmask));
//        }
        for (int i=0;i<8;i++) System.out.println(Integer.toBinaryString(1<<i));
    }
}

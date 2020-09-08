package Algorithm;

public class a152 {
    public int maxProduct(int[] nums) {
        int min,max;
        min=nums[0];
        max=nums[0];
        int res=nums[0];
        for (int i=1;i<nums.length;i++){
            int temp=min;
            min=Math.min(nums[i],Math.min(max*nums[i],min*nums[i]));
            max=Math.max(nums[i],Math.max(max*nums[i],temp*nums[i]));
            res=Math.max(res,max);
        }
        return res;
    }
}

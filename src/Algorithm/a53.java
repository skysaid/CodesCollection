package Algorithm;
//给定一个整数数组 nums, 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
public class a53 {
    public int maxSubArray(int[] nums) {
//        //记录在i位置的最大连续和
//        int[] max_sum_at_nums_i=new int[nums.length];
//        max_sum_at_nums_i[0]=nums[0];
//
//        for (int i = 1;i < nums.length;i++){
//            max_sum_at_nums_i[i]=max_sum_at_nums_i[i-1]<0?nums[i]:max_sum_at_nums_i[i-1]+nums[i];
//        }
//        int ans=Integer.MIN_VALUE;
//        for (int sum:max_sum_at_nums_i){
//            ans=sum>ans?sum:ans;
//        }
//        return ans;
        return maxsubArrayDC(nums,0,nums.length-1);

    }

    //分治法
    private int maxsubArrayDC(int[] nums, int start, int end){
        if (start==end)return nums[start];

        //先分到最下面，先计算最小单元的最大连续值
        int mid = (start+end)/2;
        int max_left = maxsubArrayDC(nums, start, mid);
        int max_right = maxsubArrayDC(nums, mid+1, end);

        //先计算左区间[start,mid]以mid为右边界的最大值
        int lmax = Integer.MIN_VALUE;
        for (int i = mid, sum=0; i >= start; i--){
            sum+=nums[i];
            lmax = Math.max(lmax, sum);
        }

        //先计算右区间[mid+1,]以mid为右边界的最大值
        int rmax = Integer.MIN_VALUE;
        for (int i = mid+1, sum=0; i <= end; i++){
            sum+=nums[i];
            rmax = Math.max(rmax, sum);
        }

        return Math.max(rmax+lmax,Math.max(max_left,max_right));
    }
}

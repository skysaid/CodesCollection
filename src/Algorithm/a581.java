package Algorithm;
//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//你找到的子数组应是最短的，请输出它的长度。
public class a581 {
    public int findUnsortedSubarray(int[] nums) {
//        int l=nums.length,r=0;
//        for (int i=0;i<nums.length-1;i++){
//            for (int j=i+1;j<nums.length;j++){
//                if (nums[i]>nums[j]){
//                    l=l<i?l:i;
//                    r=r>j?r:j;
//                }
//            }
//        }
//        return r-l<0?0:r-l+1;

        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        //第一次遍历数组找到逆序的最小值,和最大值
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]>nums[i+1]){
                min=Math.min(min,nums[i+1]);
            }
            if (nums[nums.length-i-1]<nums[nums.length-i-2]){
                max=Math.max(max,nums[nums.length-i-2]);
            }
        }


        int l=0,r=0;
        //第三次遍历获得最小值正确位置
        for (int i=0;i<nums.length;i++){
            if (nums[i]>min){
                l=i;
                break;
            }
        }
        //第四次遍历获得最大值正确位置
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]<max){
                r=i;
                break;
            }
        }
        return r-l<=0?0:r-l+1;
    }
}

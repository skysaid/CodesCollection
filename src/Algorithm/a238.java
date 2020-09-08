package Algorithm;
//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
public class a238 {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] leftM=new int[len];
        int[] rightM=new int[len];
        for (int i=0;i<len;i++){
            if (i==0){
                leftM[0]=1;
                rightM[len-1]=1;
            }else {
                leftM[i]=leftM[i-1]*nums[i-1];
                rightM[len-1-i]=rightM[len-i]*nums[len-i];
            }
        }

        for (int i=0;i<len;i++){
            nums[i]=leftM[i]*rightM[i];
        }
        return nums;
    }
}

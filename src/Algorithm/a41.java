package Algorithm;

public class a41 {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        for (int i=0;i<nums.length;i++){
            while(nums[i]<=len&&nums[i]>0&&nums[nums[i]-1]!=nums[i]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for (int i=0;i<len;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }
}

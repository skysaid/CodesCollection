package Algorithm;

public class test {
    public long findbigger(long[] nums,long target){
        if (nums==null||nums.length==0)return -1;
        if (target>nums[nums.length-1])return -1;
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=(right+left)/2;
            long temp=nums[mid];
            if (temp>target){
                right=mid;
            }else if (temp<=target){
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        long[] nums=new long[]{1,2,2,3,3,5,6};
        System.out.println(new test().findbigger(nums,2));
    }
}

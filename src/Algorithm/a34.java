package Algorithm;

public class a34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        if (nums==null||nums.length==0)return res;
        if (!find(nums,target))return res;
        res[0]=findLeft(nums,target);
        res[1]=findRight(nums,target);
        return res;
    }
    public boolean find(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(right+left)/2;
            long temp=nums[mid];
            if (temp>target){
                right=mid-1;
            }else if (temp<target){
                left=mid+1;
            }else if (temp==target){
                return true;
            }
        }
        return false;
    }
    public int findRight(int[] nums,int target){
        int left=0,right=nums.length;
        while (left<right){
            int mid=(right+left)/2;
            long temp=nums[mid];
            if (temp>target){
                right=mid;
            }else if (temp==target){
                left=mid+1;
            }else if (temp<target){
                left=mid+1;
            }
        }
        return left-1;
    }
    public int findLeft(int[] nums,int target){
        int left=0,right=nums.length;
        while (left<right){
            int mid=(right+left)/2;
            long temp=nums[mid];
            if (temp>target){
                right=mid;
            }else if (temp<target){
                left=mid+1;
            }else if (temp==target){
                right=mid;
            }
        }
        return left;
    }
}

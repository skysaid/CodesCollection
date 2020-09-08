package Algorithm;

public class a33 {
    public int search(int[] nums, int target) {
        int start=board(nums);
        int res=0;
        if (target<=nums[nums.length-1]&&target>=nums[start]){
            res=find(nums,target,start,nums.length-1);
        }else {
            res=find(nums,target,0,start-1);
        }
        return res;
    }
    private int find(int[] nums,int target,int left,int right){
        while (left<=right){
            int mid=(right-left)/2+left;
            if (nums[mid]==target)return mid;
            else if (nums[mid]<target)left=mid+1;
            else if (nums[mid]>target)right=mid-1;
        }
        return -1;
    }
    private int board(int[] nums){
        int left=nums[0],right=nums[nums.length-1];
        if (left<=right)return 0;
        left=0;
        right=nums.length;
        while (left<right){
            int mid=(right-left)/2+left;
            if (mid+1<=nums.length-1&&nums[mid]>nums[mid+1]){
                return mid+1;
            }
            else if (nums[mid-1]>nums[mid])return mid;
            else if (nums[mid]>=nums[left])left=mid+1;
            else right=mid;
        }
        return left;
    }

    public static void main(String[] args) {
//        int[] nums={4,5,6,7,0,1,2};
        int[] nums={4,3};
//        int[] nums={5,1,3};
        System.out.println(new a33().board(nums));
    }
}

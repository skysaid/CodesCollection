package Algorithm;

public class a55 {
//    public boolean canJump(int[] nums) {
//        int[] can=new int[nums.length];
//        can[nums.length-1]=nums.length-1;
//        for(int i=nums.length-1;i>=0;i--){
//            for(int j=0;j<=nums[i]&&i+j<nums.length;j++){
//                can[i]=Math.max(can[i],Math.max(can[i+j],i));
//            }
//        }
//        return can[0]==nums.length-1;
//    }

    public boolean canJump(int[] nums) {
        int canreach=0;
        for (int i=0;i<nums.length;i++){
            if (i>canreach)return false;
            if (canreach>=nums.length-1)return true;
            canreach=Math.max(canreach,i+nums[i]);
        }
        return canreach>=nums.length-1;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,1,1,4};
        new a55().canJump(nums);
    }
}

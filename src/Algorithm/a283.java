package Algorithm;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class a283 {
    public void moveZeroes(int[] nums) {
        int r=0;
        int l=0;
        while (r<nums.length){
            while (nums[r]==0){
                r++;
                if (r==nums.length)break;
            }
            if (r==nums.length)break;
            nums[l]=nums[r];
            if (r>l)nums[r]=0;
            r++;
            l++;
        }
    }
}

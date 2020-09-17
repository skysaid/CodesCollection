package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class a4 {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1==null){
//            if (nums2.length%2==1){
//                return nums2[nums2.length/2];
//            }else {
//                return ((double) nums2[nums2.length/2]+(double)nums2[nums2.length/2-1])/2;
//            }
//        }
//        if (nums2==null){
//            if (nums1.length%2==1){
//                return nums1[nums1.length>>1];
//            }else {
//                return ((double)nums1[nums1.length/2]+(double)nums1[nums1.length/2-1])/2;
//            }
//        }
//        int len=nums1.length+nums2.length;
//        int left=0,right=0;
//        int count=len/2;
//        int[] newnums=new int[len];
//        int index=0;
//
//        while(left<nums1.length&&right<nums2.length){
//            if (nums1[left]>nums2[right]){
//                newnums[index++]=nums2[right++];
//            }else {
//                newnums[index++]=nums1[left++];
//            }
//        }
//        while (left<nums1.length)newnums[index++]=nums1[left++];
//        while (right<nums2.length)newnums[index++]=nums2[right++];
//        return len%2==1?newnums[len/2]:((double)newnums[len/2]+(double)newnums[len/2-1])/2;
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        int totalLeft = (m + n + 1) / 2;

        // 在 nums1 的区间 [0, m) 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i+1;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}

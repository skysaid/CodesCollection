package Algorithm;

import java.util.LinkedList;
import java.util.PriorityQueue;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
public class a215 {
    public int findKthLargest(int[] nums, int k) {
        sortHeap(nums);
        return nums[nums.length-k];
    }
//    最大堆排序
    public void sortHeap(int[] nums){
        //从中间节点开始构造堆
        for (int i=(nums.length-1)/2;i>=0;i--){
            adjustHeap(nums,i,nums.length);
        }
        for (int i = nums.length-1;i>0;i--){
            //将堆顶元素与末尾元素进行交换
            swap(nums,0,i);
            //重新对堆进行调整
            adjustHeap(nums,0,i);
        }

    }
    public void adjustHeap(int[] nums,int parent,int len){
        //记录当前需要排序的值
        int temp=nums[parent];
        //计算左叶子节点的位置 parent，left=2*parent+1，right=2*parent+2；parent的parent=（parent-1）/2
        int leftIndex=2*parent+1;

        while(leftIndex<len){
            //比较左右子节点哪个大，哪个大就选哪个与父节点比较
            int rightIndex = leftIndex+1;
            if (rightIndex<len&&nums[rightIndex]>nums[leftIndex]){
                leftIndex++;
            }
            //都比父节点小，满足性质，退出
            if (temp>=nums[leftIndex]){
                break;
            }
            //交换，往下遍历
            nums[parent]=nums[leftIndex];
            parent=leftIndex;
            leftIndex=2*leftIndex+1;
        }
        nums[parent]=temp;
    }
    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}

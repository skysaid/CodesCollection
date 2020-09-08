package shopee;


import java.util.Scanner;

public class a1 {
    public static void heapSort(int[] nums){
        for (int i=(nums.length-1)/2;i>=0;i--){
            adjustHeap(nums,i,nums.length);
        }

        for (int i=nums.length-1;i>0;i--){
            int temp=nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            adjustHeap(nums,0,i);
        }
    }
    public static void adjustHeap(int[] nums,int parent,int len){
        int temp=nums[parent];
        int left=2*parent+1;
        while (left<len){
            int right=left+1;
            if (right<len&&nums[right]>nums[left]){
                left++;
            }
            if (temp>=nums[left])break;
            nums[parent]=nums[left];
            parent=left;
            left=2*left+1;
        }
        nums[parent]=temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str=in.nextLine();
            String[] strs=str.split(" ");
//            for (String s:strs) System.out.println(s);
            int len=strs.length;
            int[] nums=new int[len];
            for (int i=0;i<len;i++){
                nums[i]=Integer.parseInt(strs[i]);
            }
//            for (int i:nums) System.out.println(i);
            heapSort(nums);
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<len;i++){
                sb.append(nums[i]);
                sb.append(" ");
            }
            sb.delete(sb.length()-1,sb.length());
            System.out.println(sb.toString());
        }
    }
}

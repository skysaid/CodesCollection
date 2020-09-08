package 腾讯笔试;

import javax.swing.*;
import java.util.Scanner;

public class 逆序对 {

public static void mergeSort(int[] nums,int left,int mid,int right,int[] reorder,int index){
    int i=left,j=mid+1;
    int[] temp=new int[right-left+1];
    int k=0;
    int count=0;
    while (i<=mid&&j<=right){
        if (nums[i]>nums[j]){
            temp[k++]=nums[j++];
            count+=mid-i+1;
        }else {
            temp[k++]=nums[i++];
        }
    }
    while (i<=mid)temp[k++]=nums[i++];
    while (j<=right)temp[k++]=nums[j++];
    System.arraycopy(temp,0,nums,left,temp.length);
    reorder[index]+=count;
}
public static void partition(int[] nums,int left,int right,int[] reorder,int index){
    if (left<right){
        int mid=(right-left)/2+left;
        partition(nums, left, mid, reorder, index-1);
        partition(nums, mid+1, right, reorder, index-1);
        mergeSort(nums,left,mid,right,reorder,index);
    }
}

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int N=1<<n;
        int[] a=new int[N];//普通的
        int[] b=new int[N];//反过来的
        int[] reorder=new int[n+1];//逆序
        int[] order=new int[n+1];//顺序
        int temp=0;
        for (int i=0;i<N;i++){
            temp=in.nextInt();
            a[i]=temp;
            b[N-1-i]=temp;
        }
        partition(a,0,N-1,reorder,n);
        partition(b,0,N-1,order,n);
        int m=in.nextInt();
        while (m-->0){
            int res=0;
            int q=in.nextInt();
            for (int i=0;i<=q;i++){
                temp=reorder[i];
                reorder[i]=order[i];
                order[i]=temp;
            }
            for (int i:reorder)res+=i;
            System.out.print(res+" ");
        }
    }
}

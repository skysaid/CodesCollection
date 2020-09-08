public class 顺时针打印二维数组 {
    public static void printArray(int[][] nums,int istart,int iend,int jstart,int jend,int num){
        if (istart>iend||jstart>jend)return;
        for (int j=jstart;j<=jend;j++){
            nums[istart][j]=num++;
        }
        for (int i=istart+1;i<=iend;i++){
            nums[i][jend]=num++;
        }
        for (int j=jend-1;j>=jstart;j--){
            nums[iend][j]=num++;
        }
        for (int i=iend-1;i>=istart+1;i--){
            nums[i][jstart]=num++;
        }
        printArray(nums,istart+1,iend-1,jstart+1,jend-1,num);
    }

    public static void main(String[] args) {
        int[][] nums=new int[5][5];
        printArray(nums,0,4,0,4,1);
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}

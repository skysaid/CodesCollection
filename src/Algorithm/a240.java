package Algorithm;

public class a240 {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int i=matrix.length-1,j=0;
//        while (i>=0&&j<=matrix[0].length-1){
//            if (matrix[i][j]==target)return true;
//            else if (matrix[i][j]>target)i--;
//            else if (matrix[i][j]<target)j++;
//        }
//        return false;
//    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return false;
        for (int i=0;i<matrix.length;i++){
            if (find(matrix,target,i))return true;
        }
        return false;
    }
    private boolean find(int[][] matrix,int target,int i){
        int left=0;
        int right=matrix[0].length-1;
        while (left<right){
            int mid=(right-left)/2+left;
            if (matrix[i][mid]==target){
                return true;
            }else if (matrix[i][mid]<target){
                left=mid+1;
            }else if (matrix[i][mid]>target){
                right=mid-1;
            }
        }
        return matrix[i][left]==target;
    }

    public static void main(String[] args) {
        int[][] matrix={{-1,3}};
        new a240().searchMatrix(matrix,3);
    }
}

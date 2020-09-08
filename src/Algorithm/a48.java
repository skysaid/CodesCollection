package Algorithm;
//给定一个 n × n 的二维矩阵表示一个图像。 将图像顺时针旋转 90 度。
public class a48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int round=0;round<(matrix.length)/2;round++){
            for (int j=round;j<n-1-round;j++){
                int temp=matrix[round][j];
                matrix[round][j]=matrix[n-j-1][round];
                matrix[n-j-1][round]=matrix[n-round-1][n-j-1];
                matrix[n-round-1][n-j-1]=matrix[j][n-round-1];
                matrix[j][n-round-1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        new a48().rotate(new int[3][3]);
    }
}

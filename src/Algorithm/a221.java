package Algorithm;

public class a221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null||matrix.length==0)return 0;
        int[][] square=new int[matrix.length][matrix[0].length];
        int res=0;

        for (int j=0;j<matrix[0].length;j++){
            square[0][j]=matrix[0][j]-'0';
            if (matrix[0][j]=='1')res=1;
        }

        for (int i=1;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    if (j==0){
                        square[i][0]=1;
                    }else {
                        square[i][j]=Math.min(square[i][j-1],Math.min(square[i-1][j],square[i-1][j-1]))+1;
                    }
                        res=Math.max(res,square[i][j]);
                }
            }
        }
        return res*res;
    }

    public static void main(String[] args) {
        char[][] matrix={{'0'},{'1'}};
        System.out.println(new a221().maximalSquare(matrix));
    }
}

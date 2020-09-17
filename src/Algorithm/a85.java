package Algorithm;

public class a85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0)return 0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        int max=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    if (j>0){
                        dp[i][j]=dp[i][j-1]+1;
                    }else {
                        dp[i][j]=1;
                    }
                    int curi=i-1;
                    int high=1;
                    int curWidth=dp[i][j];
                    max=Math.max(max,dp[i][j]);
                    while (curi>=0&&matrix[curi][j]=='1'){
                        high++;
                        curWidth=Math.min(curWidth,dp[curi][j]);
                        max=Math.max(max,curWidth*high);
                        curi--;
                    }
                }
            }
        }
        return max;
    }
}

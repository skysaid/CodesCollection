package Algorithm;
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
public class a64 {

    public int minPathSum(int[][] grid) {
        int rlen=grid.length,clen=grid[0].length;
        int[][] curmin=new int[rlen][clen];
        curmin[0][0]=grid[0][0];
        for (int j = 0;j<clen;j++){
            for (int i=0;i<rlen;i++){
                if (i==0&&j==0)continue;
                else if (i==0&&j!=0)curmin[i][j]=curmin[i][j-1];
                else if (i!=0&&j==0)curmin[i][j]=curmin[i-1][j];
                else {
                    curmin[i][j]=Math.min(curmin[i-1][j],curmin[i][j-1]);
                }
                curmin[i][j]+=grid[i][j];
            }
        }
        return curmin[rlen-1][clen-1];
    }
//    超时
//    private void dfs(int[][] grid , int i,int j ,int sum){
//        sum+=grid[i][j];
//        if (i==grid.length-1&&j==grid[0].length-1){
//            ans=ans<sum?ans:sum;
//            return;
//        }
//        if (i==grid.length-1){
//            dfs(grid,i,j+1,sum);
//        }else if (j==grid[0].length-1){
//            dfs(grid,i+1,j,sum);
//        }else {
//            dfs(grid,i+1,j,sum);
//            dfs(grid,i,j+1,sum);
//        }
//    }
}

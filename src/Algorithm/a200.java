package Algorithm;

public class a200 {
    public int numIslands(char[][] grid) {
        if (grid==null)return 0;
        int rlen=grid.length;
        if (rlen==0)return 0;
        int clen=grid[0].length;
        if (clen==0)return 0;

        char[][] clone=grid.clone();
        int res=0;
        for (int i=0;i<rlen;i++){
            for (int j=0;j<clen;j++){
                if (clone[i][j]=='1'){
                    isisland(clone,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void isisland(char[][] grid,int i,int j){
        int rlen=grid.length,clen=grid[0].length;
        if (i<0||i==rlen||j==clen||j<0)return;
        if (grid[i][j]=='*'||grid[i][j]=='0')return;
        char temp=grid[i][j];
        grid[i][j]='*';
//        boolean up=isisland(grid,i,j-1);
//        boolean left=isisland(grid,i-1,j);
//        boolean right=isisland(grid,i+1,j);
//        boolean down=isisland(grid,i,j+1);
        isisland(grid,i,j-1);
        isisland(grid,i-1,j);
        isisland(grid,i+1,j);
        isisland(grid,i,j+1);
    }
}

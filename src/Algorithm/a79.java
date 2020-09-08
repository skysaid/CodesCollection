package Algorithm;

public class a79 {
    boolean finded=false;
    public boolean exist(char[][] board, String word) {
        if (board==null||board.length==0)return false;
        char start=word.charAt(0);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==start){
                    finded=dfs(board,word,i,j,0);
                }
                if (finded)return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int i,int j,int index){
        if (finded)return true;
        if (index==word.length()){
            finded=true;
            return true;
        }
        if (i<0||i>=board.length||j<0||j>=board[0].length)return false;
        if (board[i][j]!=word.charAt(index))return false;
        char temp=board[i][j];
        board[i][j]='0';
        boolean left=dfs(board,word,i,j-1,index+1);
        boolean right=dfs(board,word,i,j+1,index+1);
        boolean up=dfs(board,word,i-1,j,index+1);
        boolean down=dfs(board,word,i+1,j,index+1);
        board[i][j]=temp;
        return left||right||up||down;
    }
}

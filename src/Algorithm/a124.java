package Algorithm;

public class a124 {
    public int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if (root==null)return 0;
        int left=Math.max(dfs(root.left),0);
        int right=Math.max(dfs(root.right),0);
        max=Math.max(max,left+right+root.val);
        return root.val+Math.max(left,right);
    }
}

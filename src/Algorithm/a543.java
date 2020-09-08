package Algorithm;
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
public class a543 {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=1;
        int len=diameterInNode(root);
        return max-1;
    }

//    返回当前节点的最大节点数（左或者右）

    private int diameterInNode(TreeNode root){
        if (root==null)return 0;

        int max_left = diameterInNode(root.left);
        int max_right = diameterInNode(root.right);

        //更新最大节点数
        max=Math.max(max,max_left+max_right+1);

        return max_left>max_right?max_left+1:max_right+1;
    }
}

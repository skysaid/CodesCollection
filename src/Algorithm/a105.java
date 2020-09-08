package Algorithm;
//从前序与中序遍历序列构造二叉树
public class a105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=build(preorder,0,preorder.length-1,inorder, 0,inorder.length-1);
        return root;
    }
    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if (prestart>preend||instart>inend)return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int index=0;
        for (int i=instart;i<=inend;i++){
            if (preorder[prestart]==inorder[i]){
                index=i;
                break;
            }
        }
        int left=index-instart;
        root.left=build(preorder,prestart+1,prestart+left+1,inorder,instart,index-1);
        root.right=build(preorder,prestart+left+1,preend,inorder,index+1,inend);
        return root;
    }
}

package Algorithm;
//给定一个二叉树，原地将它展开为一个单链表。
public class a114 {
    public void flatten(TreeNode root) {
        if(root==null)return;
        TreeNode cur=root;
        while (cur!=null){
            if (cur.left!=null){
                TreeNode right=cur.right;
                cur.right=cur.left;
                cur.left=null;
                TreeNode temp=cur;
                while (temp.right!=null)temp=temp.right;
                temp.right=right;
            }
            cur=cur.right;
        }
    }
}

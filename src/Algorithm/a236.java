package Algorithm;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
public class a236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root.val==p.val||root.val==q.val)return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null)return right;
        if(right==null)return left;
        return root;
    }
}

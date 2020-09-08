package Algorithm;

//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

public class a538 {
    private int count=0;
    public TreeNode convertBST(TreeNode root) {
        if (root==null)return root;
        convertBST(root.right);
        root.val+=count;
        count=root.val;
        convertBST(root.left);
        return root;
    }
}

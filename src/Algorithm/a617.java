package Algorithm;

import java.util.ArrayList;

public class a617 {
    //给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
    //你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return helper(t1,t2);

    }
    private TreeNode helper(TreeNode t1, TreeNode t2){
        if (t1==null)return t2;
        if (t2==null)return t1;

        t1.val+=t2.val;
        TreeNode left=helper(t1.left,t2.left);
        TreeNode right=helper(t1.right,t2.right);
        t1.left=left;
        t1.right=right;
        return t1;
    }

}

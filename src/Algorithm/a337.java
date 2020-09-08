package Algorithm;

import java.util.HashMap;

//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
public class a337 {
    HashMap<TreeNode,Integer> now=new HashMap<>();
    HashMap<TreeNode,Integer> notnow=new HashMap<>();
    public int rob(TreeNode root) {
        helper(root);
        return Math.max(now.getOrDefault(root,0),notnow.getOrDefault(root,0));
    }
    private void helper(TreeNode root){
        if (root==null)return;
        helper(root.left);
        helper(root.right);
        now.put(root,root.val+notnow.getOrDefault(root.left,0)+notnow.getOrDefault(root.right,0));
        notnow.put(root,Math.max(now.getOrDefault(root.left,0),notnow.getOrDefault(root.left,0))+
                Math.max(now.getOrDefault(root.right,0),notnow.getOrDefault(root.right,0)));
    }
}

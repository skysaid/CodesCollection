package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

//给定一个二叉树，检查它是否是镜像对称的。
public class a101 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)return true;
        return checkSymmetric(root,root);
    }
    private boolean checkSymmetric(TreeNode n1, TreeNode n2){
//        if (n1==null&&n2==null)return true;
//        if (n1==null||n2==null)return false;
//        boolean cur = n1.val==n2.val;
//        return cur&checkSymmetric(n1.left,n2.right)&checkSymmetric(n1.right,n2.left);
        Queue<TreeNode> treeNodes = new LinkedList<>();

        treeNodes.add(n1);
        treeNodes.add(n2);

        while (!treeNodes.isEmpty()){
            TreeNode temp1=treeNodes.poll();
            TreeNode temp2=treeNodes.poll();

            if (temp1==null&&temp2==null)continue;
            if ((temp1==null||temp2==null)||(temp1.val!=temp2.val))return false;

            treeNodes.add(temp1.left);
            treeNodes.add(temp2.right);
            treeNodes.add(temp1.right);
            treeNodes.add(temp2.left);

        }
        return true;
    }
}

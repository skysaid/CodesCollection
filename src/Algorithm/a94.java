package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的中序 遍历。
public class a94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            ans.add(cur.val);
            cur=cur.right;
        }
        return ans;
    }
//    private void inorder(TreeNode root, List<Integer> ans){
//        if(root==null)return;
//        inorder(root.left,ans);
//        ans.add(root.val);
//        inorder(root.right,ans);
//    }
}
